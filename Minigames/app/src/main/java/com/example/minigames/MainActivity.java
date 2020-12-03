package com.example.minigames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout);
        getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
        //button.setVisibility(View.INVISIBLE);
        SharedPreferences sp = this.getSharedPreferences("appinfo", Context.MODE_PRIVATE);
        final boolean loggedIn = sp.getBoolean("loggedIN", false);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loggedIn) {
                    Intent selectIntent = new Intent(getApplicationContext(), SelectScreen.class);
                    startActivity(selectIntent);
                }
                else{
                    Intent selectIntent = new Intent(getApplicationContext(), SignUp.class);
                    startActivity(selectIntent);
                }
            }
        });
    }
}
