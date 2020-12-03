package com.example.minigames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
SharedPreferences sp;
String user;
    int speed=0;
    int reaction=0;
    int puzzle=0;
    int snake;
    int tictactoe;
    int focus;
    int anagram;
    int speed2=0;
    int reaction2=0;
    int puzzle2=0;
    int snake2;
    int tictactoe2;
    int focus2;
    int anagram2;
TextView userText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        sp = this.getSharedPreferences("appinfo", Context.MODE_PRIVATE);
        userText= findViewById(R.id.user);
        TextView speedTV=findViewById(R.id.hiscore3);
        TextView speedTV2=findViewById(R.id.timeplayed3);
        TextView reactionTV=findViewById(R.id.hiscore4);
        TextView reactionTV2=findViewById(R.id.timeplayed4);
        TextView puzzleTV=findViewById(R.id.hiscore5);
        TextView puzzleTV2=findViewById(R.id.timeplayed5);
        TextView snakeTV=findViewById(R.id.hiscore6);
        TextView snakeTV2=findViewById(R.id.timeplayed6);
        TextView tttTV=findViewById(R.id.hiscore7);
        TextView tttTV2=findViewById(R.id.timeplayed7);
        TextView focusTV=findViewById(R.id.hiscore8);
        TextView focusTV2=findViewById(R.id.timeplayed8);
        TextView anagramTV=findViewById(R.id.hiscore9);
        TextView anagramTV2=findViewById(R.id.timeplayed9);
        profileInfo();
        userText.setText(user);
        speedTV.setText(String.valueOf(speed2));
        speedTV2.setText(String.valueOf(speed));
        reactionTV.setText(String.valueOf(reaction2));
        reactionTV2.setText(String.valueOf(reaction));
        puzzleTV.setText(String.valueOf(puzzle2));
        puzzleTV2.setText(String.valueOf(puzzle));
        snakeTV.setText(String.valueOf(snake2));
        snakeTV2.setText(String.valueOf(snake));
        //tttTV.setText(String.valueOf(tictactoe2));
        tttTV2.setText(String.valueOf(tictactoe));
        focusTV.setText(String.valueOf(focus2));
        focusTV2.setText(String.valueOf(focus));
        anagramTV.setText(String.valueOf(anagram2));
        anagramTV2.setText(String.valueOf(anagram));

    }
    public void profileInfo() {
        user=sp.getString("username", "");
        speed = sp.getInt("speed",0);
        speed2 = sp.getInt("speed2",0);
        reaction = sp.getInt("reaction",0);
        reaction2 = sp.getInt("reaction2",0);
        puzzle = sp.getInt("puzzle",0);
        puzzle2 = sp.getInt("puzzle2",0);
        snake = sp.getInt("snake",0);
        snake2 = sp.getInt("snake2",0);
        tictactoe = sp.getInt("tictactoe",0);
        tictactoe2 = sp.getInt("tictactoe2",0);
        focus = sp.getInt("focus",0);
        focus2 = sp.getInt("focus2",0);
        anagram = sp.getInt("anagram",0);
        anagram2 = sp.getInt("anagram2",0);

    }
}
