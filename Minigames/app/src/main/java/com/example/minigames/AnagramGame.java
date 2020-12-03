package com.example.minigames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AnagramGame extends AppCompatActivity {
    private OkHttpClient client;
    private String word = "";
    private int score;
    private TextView scoreText;
    private Button[] letters;
    private String validLetters;
    private TextView errMsg;
    private boolean isRunning;
    private EditText wordIn;
    private HashSet<String> wordsUsed;
    private int high;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp=this.getSharedPreferences("appinfo", Context.MODE_PRIVATE);
        client = new OkHttpClient();
        score = 0;
        isRunning = true;
        setContentView(R.layout.activity_anagram_game);

        wordsUsed = new HashSet<>();
        errMsg = findViewById(R.id.anErrorMsg);
        wordIn = findViewById(R.id.userIn);
        TextView st = findViewById(R.id.anagramScore);
        scoreText = st;
        word = wordIn.getText().toString();
        wordIn.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                word = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        initBoard();
        setBoard();

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                scoreText.setText("Score: " + score);
            }
        };

        Runnable runnable = new Runnable() {
            public void run() {
                int last = 0;
                while(true){
                    if(last < score) {
                        Message msg = handler.obtainMessage();
                        Bundle bundle = new Bundle();
                        String s = "" + score;
                        bundle.putString("score", s);
                        msg.setData(bundle);
                        handler.sendMessage(msg);
                        last = score;
                    }
                }
            }
        };
        Thread mythread = new Thread(runnable);
        mythread.start();

        final TextView clock =findViewById(R.id.anagramTimer);
        new CountDownTimer(120000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String minutes = String.valueOf(((millisUntilFinished / 1000) / 60));
                String seconds = String.valueOf(((millisUntilFinished / 1000) % 60));
                if(seconds.length() < 2){
                    seconds = "0" + seconds;
                }
                clock.setText("Time left: " + minutes + ":" + seconds);

            }
            @Override
            public void onFinish() {
                clock.setText("Finished");
                isRunning = false;
                updateScore();
                //send to server here
            }
        }.start();

        /*
        Button refreshLetters = findViewById(R.id.newLetters);
        refreshLetters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBoard();
            }
        });*/



        Button clear = findViewById(R.id.clearTextButton);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wordIn.setText("");
            }
        });


        Button submit = findViewById(R.id.submitText);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(isRunning) {
                        if (!usesValidLetters(word)) {
                            setErrMsg("You must only use the valid letters below!", false);
                        }
                        else if(!wordAlreadyUsed(word)){
                            setErrMsg("You already used that word!", false);
                        }
                        else{
                            wordAPICall(word);
                            wordsUsed.add(word);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private boolean wordAlreadyUsed(String word){
        return !wordsUsed.contains(word);
    }

    private void setErrMsg(String msg, boolean correct){
        if(correct){
            errMsg.setTextColor(Color.GREEN);
        }
        else{
            errMsg.setTextColor(Color.RED);
        }
        errMsg.setText(msg);
    }


    private boolean wordAPICall(String word) throws IOException {
        System.out.println("-----------------------------------------------");
        System.out.println(word);
        System.out.println("-----------------------------------------------");

        Request request = new Request.Builder()
                .url("https://wordsapiv1.p.rapidapi.com/words/" + word)
                .get()
                .addHeader("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "6380829c1dmsh3b3e44233321004p14ca18jsnebb2768d7ac1")
                .build();

        //Response response = client.newCall(request).execute();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String mMessage = e.getMessage().toString();
                System.out.println(mMessage);
                //Log.w("failure Response", mMessage);
                //call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    setErrMsg("Well Done!", true);
                    score++;
                }
                else{
                    setErrMsg("That is not a word!", false);
                }
                String mMessage = response.body().string();
                System.out.println(mMessage);
            }
        });



        return false;
    }

    private void initBoard(){
        letters = new Button[6];
        letters[0] = findViewById(R.id.letter1);
        letters[1] = findViewById(R.id.letter2);
        letters[2] = findViewById(R.id.letter3);
        letters[3] = findViewById(R.id.letter4);
        letters[4] = findViewById(R.id.letter5);
        letters[5] = findViewById(R.id.letter6);
        for(int i = 0; i < 6; i++){
            final int finalI = i;
            letters[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wordIn.append("" + validLetters.charAt(finalI));
                }
            });
        }
    }


    private void setBoard(){
        Random rand = new Random();
        int vowel1 = rand.nextInt(5);
        int vowel2 = rand.nextInt(5);
        String vowels = "aeiou";
        validLetters = "";
        letters[0].setText("" + vowels.charAt(vowel1));
        validLetters = validLetters + vowels.charAt(vowel1);
        while(vowel2 == vowel1){
            vowel2 = rand.nextInt(5);
        }
        letters[5].setText("" + vowels.charAt(vowel2));


        int curSet = 1;
        while(curSet < 5){
            String consonants = "bcdfghjklmnpqrstv"; //Excluding w,x,y,z for simplicity
            int c =rand.nextInt(21 - 4);
            if(!validLetters.contains("" + consonants.charAt(c))) {
                letters[curSet].setText("" + consonants.charAt(c));
                validLetters = validLetters + consonants.charAt(c);
                curSet++;
            }
        }
        validLetters = validLetters + vowels.charAt(vowel2);
    }

    private boolean usesValidLetters(String word){
        for(int i = 0; i < word.length(); i++){
            if(validLetters.indexOf(word.charAt(i)) < 0){
                return false;
            }
        }
        return true;
    }
    public void updateScore(){
        high=sp.getInt("anagram2",0);
        if (score>high) high=score;
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("anagram2",high);
        editor.commit();
    }

}
