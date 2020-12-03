package com.example.minigames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Speed extends AppCompatActivity {
    CountDownTimer countDownTimer;
    private long timeLeftMs=5000;
    TextView timerTV;
    TextView scoreTV;
    TextView roundTV;
    Button mashButton;
    private int score=0;
    boolean running = false;
    long interval = 10;
    private boolean replay=false;
    int round=1;
    int passScore;
    View v7;
    Button contButton;
    SharedPreferences sp;
    int high=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);
        mashButton= (Button) findViewById(R.id.mashButton);
        timerTV=(TextView) findViewById(R.id.timerText);
        scoreTV=(TextView) findViewById(R.id.scoreText);
        roundTV=(TextView) findViewById(R.id.roundTV);
        sp=this.getSharedPreferences("appinfo", Context.MODE_PRIVATE);
        passScore=20+(4*round);
        v7 = findViewById(R.id.contButton);
        continueButtonDisappear(v7);
        contButton=(Button)v7;
        mashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPress();
            }
        });
        contButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                replay();
            }
        });
    }

    public void startTimer() {
        timeLeftMs=5000;
        countDownTimer = new CountDownTimer(timeLeftMs, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftMs = millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {
                running = false;
                if(score>=passScore) {
                    timerTV.setText("Round Passed, you got more than " + String.valueOf(passScore) + " presses");
                    continueButtonAppear(v7);
                }
                else timerTV.setText("Round Failed, you got less than "+String.valueOf(passScore)+" presses");
                updateScore();
                //send to server here
            }
        };
        countDownTimer.start();
        running = true;
    }
    public void continueButtonAppear(View v){
        v.setVisibility(View.VISIBLE);
    }
    public void continueButtonDisappear(View v){
        v.setVisibility(View.INVISIBLE);
    }
    public void replay(){
        score=0;
        round++;
        passScore=20+(4*round);
        roundTV.setText("Round: "+String.valueOf(round));
        mashButton.setText("The round begins when you press this button, you need " +
                String.valueOf(passScore) + " presses to pass the next round.Good Luck!");
        continueButtonDisappear(v7);
    }
    public void stopTimer() {
        countDownTimer.cancel();
        running = false;
    }

    public void updateTimer() {
        String time="";
        int seconds=(int) timeLeftMs% 60000 /1000;
        time+=seconds+":";
        int ms= (int) timeLeftMs/10 %100;
        if(ms<10) {
            time += "0";
            time += ms;
        }
        else
        time +=ms;
                timerTV.setText(time);
    }
    public void buttonPress(){
        if(score==0){
            startTimer();
            mashButton.setText("");
            roundTV.setText("Round: "+String.valueOf(round));
        }
        if(running){
            score++;
            scoreTV.setText("Score: " +String.valueOf(score));
        }
        else{
            if(replay==false){
                mashButton.setText("Press to Return to Menu");
                Intent menuIntent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(menuIntent);
            }

        }
    }
    public void updateScore(){
        high=sp.getInt("speed2",0);
        if (score>high) high=score;
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("speed2",high);
        editor.commit();
    }
}
