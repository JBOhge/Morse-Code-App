package com.example.minigames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class Reaction extends AppCompatActivity {

    //long timer; //represents the timer (hopefully in milliseconds
    int score = 0;                                                      //represents the score
    CountDownTimer countdowntimer;
    Random rand;                                                        //random variable (doesn't need to be instance var)
    String colorDisp;                                          //tells player which button to press (always starts with green)
    String user = "username";
    long timeLeftMs;
    long interval=16;
    TextView color;
    CountDownTimer countDownTimer;
    boolean running;
    boolean roundPass;
    boolean lose=false;
    // private RequestQueue submitQueue;
    TextView sndmsg;
    //final String url = "http://coms-309-nv-7.cs.iastate.edu:8080/user/";
    int high;
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction);
        //submitQueue = Volley.newRequestQueue(this);
        getWindow().getDecorView().setBackgroundColor(Color.BLACK);
        sp=this.getSharedPreferences("appinfo", Context.MODE_PRIVATE);;
        /* code is the same for each button other than the buttons and IDs */
        Button green = (Button) findViewById(R.id.green);
        generateColor();
       // sndmsg = (TextView) findViewById(R.id.sendMessage);//makes the button work
        green.setOnClickListener(new View.OnClickListener() {                //allows the button to do something when pressed
            @Override
            public void onClick(View v) {                               //each onClick needs different view variable

                TextView points = (TextView) findViewById(R.id.points); //points text variable
                if (colorDisp.equals("green")&&!lose) {
                    score++;
                    points.setText(score + "");                         //changes the score for each
                    roundPass=true;
                    if (score>1)
                    stopTimer();
                    generateColor();                                    //prompt a different button to be pressed
                } else {                                                   //the wrong button was pressed
                    score = 0;                                            //score resets to zero
                    //points.setText(score + "");                         //score is diplayed
                    lose=true;
                }
            }

        });
        Button red = (Button) findViewById(R.id.red);
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {

                TextView points = (TextView) findViewById(R.id.points);
               // TextView hiscore = (TextView) findViewById(R.id.high);
                if (colorDisp.equals("red")&&!lose) {
                    score++;
                    points.setText(score + "");                         //changes the score for each
                    roundPass=true;
                    if (score>1)
                    stopTimer();
                    generateColor();                                    //prompt a different button to be pressed
                } else {                                                   //the wrong button was pressed
                    score = 0;                                            //score resets to zero
                   // points.setText(score + "");                         //score is diplayed
                    lose=true;
                }
            }
        });
        Button yellow = (Button) findViewById(R.id.yellow);
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View b) {

                TextView points = (TextView) findViewById(R.id.points);
                //TextView hiscore = (TextView) findViewById(R.id.high);
                if (colorDisp.equals("yellow")&&!lose) {
                    score++;
                    points.setText(score + "");                         //changes the score for each
                    roundPass=true;
                    if (score>1)
                    stopTimer();
                    generateColor();                                    //prompt a different button to be pressed
                } else {                                                   //the wrong button was pressed
                    score = 0;                                            //score resets to zero
                    //points.setText(score + "");                         //score is diplayed
                    lose=true;
                }
            }
        });
        Button blue = (Button) findViewById(R.id.blue);
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View c) {

                TextView points = (TextView) findViewById(R.id.points);
               // TextView hiscore = (TextView) findViewById(R.id.high);
                if (colorDisp.equals("blue")&&!lose) {
                    score++;
                    points.setText(score + "");                         //changes the score for each
                    roundPass=true;
                    if (score>1)
                    stopTimer();
                    generateColor();                                    //prompt a different button to be pressed
                } else {                                                   //the wrong button was pressed
                    score = 0;                                            //score resets to zero
                   // points.setText(score + "");                         //score is diplayed
                    lose=true;
                }
            }
        });
        //saves the players score, returns to the menu and sends score to the leaderboards page, where it can be uploaded
       /* Button doneButton = (Button) findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View c) {

                Intent EndScreenIntent = new Intent(getApplicationContext(), EndScreen.class);

                //sndmsg.setText("Sending score to the server... Please Wait.");
                EditText username= (EditText)findViewById(R.id.nameBox);
                user = username.getText().toString();
                EndScreenIntent.putExtra("user",user);
                EndScreenIntent.putExtra("score", score);
                EndScreenIntent.putExtra("high", high);
                EndScreenIntent.putExtra("perfect", perfect);
                EndScreenIntent.putExtra("great", great);
                EndScreenIntent.putExtra("good", good);
                EndScreenIntent.putExtra("ok", ok);
                EndScreenIntent.putExtra("miss", miss);

                //add sending to the server
                startActivity(EndScreenIntent);
            }
        });
*/
    }

    /* function declared outside of the onCreate block
    generates one of the 4 colors at random
     */
    public void generateColor() {
        color = (TextView) findViewById(R.id.colorGen);
        rand = new Random();
        int num = rand.nextInt(4) + 1;
        if(score!=0)
            startTimer();
        if (num == 1) {
            colorDisp = "green";
            color.setTextColor(Color.parseColor("#006400"));
        }
        if (num == 2) {
            colorDisp = "red";
            color.setTextColor(Color.parseColor("#FF0000"));
        }
        if (num == 3) {
            colorDisp = "yellow";
            color.setTextColor(Color.parseColor("#FFFF00"));
        }
        if (num == 4) {
            colorDisp = "blue";
            color.setTextColor(Color.parseColor("#0000FF"));
        }

        color.setText(colorDisp);                                       //sets the text to the color that was generated

    }
    public void startTimer() {
        timeLeftMs=1200-(30*score);
        if(timeLeftMs<200){
            timeLeftMs=200;
        }
        countDownTimer = new CountDownTimer(timeLeftMs, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftMs = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                running = false;
                color.setTextColor(Color.parseColor("#FFFFFF"));
                color.setText("Game Over");
                lose=true;
                updateScore();
                //send to server here
            }
        };
        countDownTimer.start();
        running = true;
    }
    public void stopTimer(){
        countDownTimer.cancel();
        running=false;
    }
    //need a way for the game to end, when the timer ends or when the wrong button is pressed, show an end result screen
    //could make a hit button method that takes care of incrementing score and whatnot

    public void updateScore(){
        high=sp.getInt("reaction2",0);
        if (score>high) high=score;
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("reaction2",high);
        editor.commit();
    }
}
