package com.example.minigames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Maze extends AppCompatActivity {
    private boolean running;
    private TextView timerTV;
    private TextView timerTV2;
    private TextView timerTV3;
    private TextView roundTV;
    private CountDownTimer countDownTimer;
    private long timeLeftMs = 5000;
    private long interval = 10;
    private int j=0;
    MediaPlayer mp;

    private Button[] buttons = new Button[25];
    private Boolean[] bool = new Boolean[25];
    private Boolean[] bool2 = new Boolean[25];
    private int screenWidth;
    private int screenHeight = 2712;
    private int refHeight = 904;
    private int buttonHeight = 361;
    private int buttonWidth = 100;
    private int round =0;
    public View buttonview;
    int high;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maze);
    sp=this.getSharedPreferences("appinfo", Context.MODE_PRIVATE);;
        //Get Screen Size
        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
        refHeight = screenHeight * 1 / 4;
        //buttonHeight= ;
        //buttonWidth= screenWidth*(2/15);
        buttonview= findViewById(R.id.continueButton);
        roundTV= (TextView) findViewById(R.id.roundView);

        timerTV = (TextView) findViewById(R.id.timerTV);
        timerTV2 = (TextView) findViewById(R.id.timerTV2);
        timerTV3 = (TextView) findViewById(R.id.timerTV3);
        final Button readyButton = (Button) findViewById(R.id.readyButton);
        final Button continueButton = (Button) findViewById(R.id.continueButton);

       // timerTV.setText("buttonheight: " + String.valueOf(buttonHeight));
        //timerTV2.setText("buttonwidth: " + String.valueOf(buttonWidth));
        //timerTV3.setText("screenheight: " + String.valueOf(screenHeight));

        buttons[0] = findViewById(R.id.mazeButton);
        buttons[1] = findViewById(R.id.mazeButton2);
        buttons[2] = findViewById(R.id.mazeButton3);
        buttons[3] = findViewById(R.id.mazeButton4);
        buttons[4] = findViewById(R.id.mazeButton5);
        buttons[5] = findViewById(R.id.mazeButton6);
        buttons[6] = findViewById(R.id.mazeButton7);
        buttons[7] = findViewById(R.id.mazeButton8);
        buttons[8] = findViewById(R.id.mazeButton9);
        buttons[9] = findViewById(R.id.mazeButton10);
        buttons[10] = findViewById(R.id.mazeButton11);
        buttons[11] = findViewById(R.id.mazeButton12);
        buttons[12] = findViewById(R.id.mazeButton13);
        buttons[13] = findViewById(R.id.mazeButton14);
        buttons[14] = findViewById(R.id.mazeButton15);
        buttons[15] = findViewById(R.id.mazeButton16);
        buttons[16] = findViewById(R.id.mazeButton17);
        buttons[17] = findViewById(R.id.mazeButton18);
        buttons[18] = findViewById(R.id.mazeButton19);
        buttons[19] = findViewById(R.id.mazeButton20);
        buttons[20] = findViewById(R.id.mazeButton21);
        buttons[21] = findViewById(R.id.mazeButton22);
        buttons[22] = findViewById(R.id.mazeButton23);
        buttons[23] = findViewById(R.id.mazeButton24);
        buttons[24] = findViewById(R.id.mazeButton25);

        mp=MediaPlayer.create(this, R.raw.woo);
        for(int i=0;i<bool.length; i++){
            bool[i]=false;
        }
        readyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                round++;
                configButtons();
                readyButton.setVisibility(View.INVISIBLE);
                continueButton.setVisibility(View.INVISIBLE);
                createPath();
                startTimer();
            }
        });

        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                checkPath(0);
            }
        });
        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(1);
            }
        });
        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(2);
            }
        });
        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(3);
            }
        });
        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(4);
            }
        });
        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(5);
            }
        });
        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(6);
            }
        });
        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(7);
            }
        });
        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(8);
            }
        });
        buttons[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(9);
            }
        });
        buttons[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(10);
            }
        });
        buttons[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(11);
            }
        });
        buttons[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(12);
            }
        });
        buttons[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(13);
            }
        });
        buttons[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(14);
            }
        });
        buttons[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(15);
            }
        });
        buttons[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(16);
            }
        });
        buttons[17].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(17);
            }
        });
        buttons[18].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(18);
            }
        });
        buttons[19].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(19);
            }
        });
        buttons[20].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(20);
            }
        });
        buttons[21].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(21);
            }
        });
        buttons[22].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(22);
            }
        });
        buttons[23].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(23);
            }
        });
        buttons[24].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                    checkPath(24);
            }
        });
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                round++;
                configButtons();
                hidePath();
                readyButton.setVisibility(View.INVISIBLE);
                continueButton.setVisibility(View.INVISIBLE);
                createPath();
                startTimer();
            }
        });
}
    public void configButtons(){
        for(int i=0;i<buttons.length; i++){

           // buttons[i].getLayoutParams().height = screenHeight*(2/15) ;
           // buttons[i].getLayoutParams().width = screenWidth*(2/15) ;
            if(i==0){
                buttons[i].setText(String.valueOf(1));
            }
            else if(i==24){
                buttons[i].setText(String.valueOf(2));
            }else {
                buttons[i].setText(String.valueOf(i + 2));
            }
            buttons[i].setTextColor(Color.WHITE);
           /* //setting x coordinates
            if(i%5==0){
                buttons[i].setX(0);
            }
            if(i%5==1){
                buttons[i].setX(screenWidth*(1/5));
            }
            if(i%5==2){
                buttons[i].setX(screenWidth*(2/5));

            }
            if(i%5==3){
                buttons[i].setX(screenWidth*(3/5));

            }
            else{ // last in the row
                buttons[i].setX(screenWidth*(4/5));
            }
            //setting y coordinates
            if(i<5){
                buttons[i].setY(refHeight);
            }
            if(i>5 && i<10){
                buttons[i].setY(refHeight + buttonHeight);
            }
            if(i>10 && i<15){
                buttons[i].setY(refHeight +buttonHeight*2 );

            }
            if(i>15 && i<20){
                buttons[i].setY(refHeight+ buttonHeight*3);

            }
            else{ // last in the column
                buttons[i].setY(refHeight + buttonHeight*4);
            }
*/
        }
    }
    public void createPath(){
        for(int i=0;i<10; i++){
            Random rand= new Random();
             int tile = rand.nextInt(25);
            buttons[tile].setBackgroundColor(Color.YELLOW);
            buttons[tile].setTextColor(Color.BLACK);
            bool[tile]=true;
        }
        bool2=bool;
    }
    public void checkPath(int i){
        if(bool[i]){
            buttons[i].setBackgroundColor(Color.YELLOW);
            buttons[i].setTextColor(Color.BLACK);
            bool[i]=false;
        }else{
            gameOver();
        }
        checkWin();
    }
    public void gameOver(){
        timerTV.setText("Better Luck Next Time");
        mp=MediaPlayer.create(this,R.raw.boo);
        mp.start();
        //stopTimer();
        revealPath();
        updateScore();
        //send to server here
        running=true;
    }
    public void revealPath(){
        for(int i=0; i<bool2.length;i++) {
            if (bool2[i]) {
                buttons[i].setBackgroundColor(Color.YELLOW);
                buttons[i].setTextColor(Color.BLACK);
            }
        }
    }
    public void hidePath(){
            for(int i=0;i<buttons.length; i++){
                buttons[i].setBackgroundColor(Color.BLACK);
                buttons[i].setTextColor(Color.WHITE);
            }
    }
    public void checkWin() {
        Boolean win=true;
        for (int i = 0; i < bool.length; i++) {
            if(bool[i]){
                win=false;
            }
        }
        if(win){
            timerTV.setText("You Win!!! ");
            roundTV.setText("Round: "+String.valueOf(round));
            mp.start();
            continueButtonAppear(buttonview);
            setAllFalse();
            //hidePath();
        }
    }
    public void continueButtonAppear(View v){
        v.setVisibility(View.VISIBLE);
    }
    public void setAllFalse(){
        for(int i=0;i<bool.length; i++){
            bool[i]=false;
        }
    }
    public void startTimer() {
        if(round<3){
            timeLeftMs=5000;
        }
        if(round>=3 && round<8){
            timeLeftMs=4000;
        }
        if(round>=8 && round<12){
            timeLeftMs=3000;
        }
        if(round>=12 && round<20){
            timeLeftMs=1000;
        }
        if(round>=20){
            timeLeftMs=1000;
        }
        countDownTimer = new CountDownTimer(timeLeftMs, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftMs = millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {
                running = false;
                hidePath();
                timerTV.setText("Reveal the Path");
                // endButtonAppear(v7);

            }
        };
        countDownTimer.start();
        running = true;
    }

    public void stopTimer() {
        countDownTimer.cancel();
        running = false;
    }

    public void updateTimer() {
        timerTV.setText(String.valueOf(timeLeftMs));
    }
    public void updateScore(){
        high=sp.getInt("puzzle2",0);
        if (round>high) high=round;
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("puzzle2",high);
        editor.commit();
    }
}
