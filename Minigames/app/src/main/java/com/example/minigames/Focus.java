package com.example.minigames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Focus extends AppCompatActivity {
PreciseCountdown timer;

ImageView hazard;
ImageView stick;

Button jumpButton;
Button heightPower;
Button speedPower;
Button retry;

TextView textView;

int screenWidth;
int screenHeight;

boolean descent=false;
boolean jump=false;
long jumpHeight;
long interval=16;
long restHeight;
boolean reached;
int velocity=25;
boolean play;

float hazardX;
float startingX=-20.f;

int score;
int hazRate=5;

View v0;
int high;
SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus);

        sp=this.getSharedPreferences("appinfo", Context.MODE_PRIVATE);

        //Get Screen Size
        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size= new Point();
        disp.getSize(size);
        screenWidth=size.x;
        screenHeight = size.y;

        timer = new PreciseCountdown(600000,interval,0) {
            @Override
            public void onTick(long timeLeft) {
                animate();
                animate2();
                checkCollision();
            }

            @Override
            public void onFinish() {

            }
        };

        stick = (ImageView)findViewById(R.id.stick);
        hazard = (ImageView)findViewById(R.id.hazard);


        jumpButton=(Button)findViewById(R.id.jump);
        speedPower = findViewById(R.id.speedButton);
        heightPower=findViewById(R.id.heightButton);
        retry = findViewById(R.id.retryButton);
        v0=findViewById(R.id.retryButton);

        textView=findViewById(R.id.textView);


        restHeight =800;
        jumpHeight =200;
        stick.setY(restHeight);

        hazard.setX(startingX);

    jumpButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            jump();
            play=true;
            if(reached)
                textView.setText("Score:"+String.valueOf(score));
            if (score%5==0) hazRate+=5;
        }
    });
    heightPower.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(jumpHeight>=-50)
                jumpHeight-=50;
        }
    });
    speedPower.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            velocity+=5;
        }
    });
    retry.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Reset();
        }
    });
        timer.start();
    }

    public abstract class PreciseCountdown extends Timer {
        private long totalTime, interval, delay;
        private TimerTask task;
        private long startTime = -1;
        private boolean restart = false, wasCancelled = false, wasStarted = false;

        public PreciseCountdown(long totalTime, long interval) {
            this(totalTime, interval, 0);
        }

        public PreciseCountdown(long totalTime, long interval, long delay) {
            super("PreciseCountdown", true);
            this.delay = delay;
            this.interval = interval;
            this.totalTime = totalTime;
            this.task = getTask(totalTime);
        }

        public void start() {
            wasStarted = true;
            this.scheduleAtFixedRate(task, delay, interval);
        }

        public void restart() {
            if(!wasStarted) {
                start();
            }
            else if(wasCancelled) {
                wasCancelled = false;
                this.task = getTask(totalTime);
                start();
            }
            else{
                this.restart = true;
            }
        }

        public void stop() {
            this.wasCancelled = true;
            this.task.cancel();
        }

        public void dispose(){
            cancel();
            purge();
        }

        private TimerTask getTask(final long totalTime) {
            return new TimerTask() {

                @Override
                public void run() {

                    long timeLeft;
                    if (startTime < 0 || restart) {
                        startTime = scheduledExecutionTime();
                        timeLeft = totalTime;
                        restart = false;
                    } else {
                        timeLeft = totalTime - (scheduledExecutionTime() - startTime);

                        if (timeLeft <= 0) {
                            this.cancel();
                            startTime = -1;
                            runOnUiThread(new Runnable() {

                                @Override
                                public void run() {
                                    onFinish();
                                }
                            });

                            return;
                        }
                    }

                    onTick(timeLeft);
                }
            };
        }

        public abstract void onTick(long timeLeft);
        public abstract void onFinish();
    }
    void Reset(){
        play = true;
        score=0;
        velocity=25;
        hazardX=startingX;
        hazard.setX(startingX);
        hazRate=5;
        stick.setY(restHeight);
        jumpHeight=200;
        timer.restart();
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                v0.setVisibility(View.INVISIBLE);
            }
        });
    }
    void jump(){
        if(jump) return;
        else jump=!jump;
    }
    void animate(){
        if (jump){
            float height = stick.getY();

            if (descent){
                height+=velocity;
            }else{
                height-=velocity;
            }
            if (height<=jumpHeight){
                descent =true;
                reached =true;
                height=jumpHeight-1;
            }
            if(height>=restHeight){
                height=restHeight;
                descent=false;
                jump=false;
            }
            stick.setY(height);
        }
        else return;
    }
    void animate2(){
        if(play){
            hazardX+=hazRate;
            if (hazardX>=screenWidth){
                score++;
                hazardX=startingX;
            }
            hazard.setX(hazardX);
        }
    }
    void checkCollision(){
        if(stick.getY()>=780 && hazard.getX()<=680 && hazard.getX()>=560){
            gameOver();
        }
    }
    void gameOver(){
        play=false;
        timer.stop();
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                v0.setVisibility(View.VISIBLE);
            }
        });
        updateScore();
        //send to server here
    }
    public void updateScore(){
        high=sp.getInt("focus2",0);
        score--;
        if (score>high) high=score;
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("focus2",high);
        editor.commit();
    }
}
