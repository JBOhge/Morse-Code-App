package com.example.minigames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class SelectScreen extends AppCompatActivity {
    private int screenWidth;
    private int screenHeight;
    SharedPreferences sp;
    int speed=0;
    int reaction=0;
    int puzzle=0;
    int snake=0;
    int tictactoe=0;
    int focus=0;
    int anagram=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_screen);
        Button[] buttons = new Button[10];
        Button button1=(Button) findViewById(R.id.button);
        Button button2=(Button) findViewById(R.id.button2);
        Button button3=(Button) findViewById(R.id.button3);
        Button button4=(Button) findViewById(R.id.button4);
        Button button5=(Button) findViewById(R.id.button5);
        Button button6=(Button) findViewById(R.id.button6);
        Button button7=(Button) findViewById(R.id.button7);
        Button button8=(Button) findViewById(R.id.button8);
        Button button9=(Button) findViewById(R.id.button9);
        Button button10=(Button) findViewById(R.id.button10);

        buttons[0]=button1;
        buttons[1]=button2;
        buttons[2]=button3;
        buttons[3]=button4;
        buttons[4]=button5;
        buttons[5]=button6;
        buttons[6]=button7;
        buttons[7]=button8;
        buttons[8]=button9;
        buttons[9]=button10;

        sp = this.getSharedPreferences("appinfo", Context.MODE_PRIVATE);

        //Get Screen Size
        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size= new Point();
        disp.getSize(size);
        screenWidth=size.x;
        screenHeight = size.y;
        for (int i=0; i<buttons.length;i++) {
            if(i%2==0)
                buttons[i].setX(0);
            else
                buttons[i].setX(screenWidth/2 -150);

            buttons[i].getLayoutParams().height = screenHeight/5 -100;
            buttons[i].getLayoutParams().width = screenWidth/2 - 50;
            if(i<2){
                buttons[i].setY(0);
            }
            else if(i>=2 && i<4){
                buttons[i].setY((float)(screenHeight*(1/5)));
            }
            else if(i>=4 && i<6){
                buttons[i].setY((float)(screenHeight*(2/5)));
            }
            else if(i>=6 && i<8){
                buttons[i].setY((float)(screenHeight*(3/5)));
            }
            else{
                buttons[i].setY((float)(screenHeight*(4/5)));
            }
        }
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                speed=sp.getInt("speed",0);
                speed++;
                editor.putInt("speed", speed);
                editor.commit();
                Intent speedIntent = new Intent(getApplicationContext(), Speed.class);
                startActivity(speedIntent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                SharedPreferences.Editor editor = sp.edit();
                reaction=sp.getInt("reaction",0);
                reaction++;
                editor.putInt("reaction", reaction);
                editor.commit();
                Intent reactionIntent = new Intent(getApplicationContext(), Reaction.class);
                startActivity(reactionIntent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                SharedPreferences.Editor editor = sp.edit();
                puzzle=sp.getInt("puzzle",0);
                puzzle++;
                editor.putInt("puzzle", puzzle);
                editor.commit();
                Intent mazeIntent = new Intent(getApplicationContext(), Maze.class);
                startActivity(mazeIntent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                SharedPreferences.Editor editor = sp.edit();
                snake=sp.getInt("snake",0);
                snake++;
                editor.putInt("snake", snake);
                editor.commit();
                Intent snakeIntent = new Intent(getApplicationContext(), Snake.class);
                startActivity(snakeIntent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v4) {
                SharedPreferences.Editor editor = sp.edit();
                tictactoe=sp.getInt("tictactoe",0);
                tictactoe++;
                editor.putInt("tictactoe", tictactoe);
                editor.commit();
                Intent TictacToeIntent = new Intent(getApplicationContext(), TicTacToe.class);
                startActivity(TictacToeIntent);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v5) {
                SharedPreferences.Editor editor = sp.edit();
                focus=sp.getInt("focus",0);
                focus++;
                editor.putInt("focus", focus);
                editor.commit();
                Intent FocusIntent = new Intent(getApplicationContext(), Focus.class);
                startActivity(FocusIntent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v6) {
                signOut();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v7) {
                SharedPreferences.Editor editor = sp.edit();
                anagram=sp.getInt("anagram",0);
                anagram++;
                editor.putInt("anagram", anagram);
                editor.commit();
                openAnagramGame();
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v8) {
                Intent LeaderboardsIntent = new Intent(getApplicationContext(), Leaderboards.class);
                startActivity(LeaderboardsIntent);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v9) {
                Intent ProfileIntent = new Intent(getApplicationContext(), Profile.class);
                startActivity(ProfileIntent);
            }
        });


    }

    private void openAnagramGame(){
        Intent intent = new Intent(this, AnagramGame.class);
        startActivity(intent);
    }

    private void signOut(){
        SharedPreferences sp = this.getSharedPreferences("appinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("loggedIN", false);
        editor.commit();

        Intent loginIntent = new Intent(this, SignUp.class);
        startActivity(loginIntent);
    }
}
