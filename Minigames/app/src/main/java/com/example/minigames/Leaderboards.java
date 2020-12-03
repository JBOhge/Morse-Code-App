package com.example.minigames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class Leaderboards extends AppCompatActivity {
    private String url = "http://coms-319-114.cs.iastate.edu:8080/stats/all";
    private TextView mostPlayedScore;
    private TextView gameScores[];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);
        mostPlayedScore = findViewById(R.id.mostPlayedScore2);
        getHighScore();
        gameScores = new TextView[6];
        gameScores[0] = findViewById(R.id.game1score);
        gameScores[1] = findViewById(R.id.game2score);
        gameScores[2] = findViewById(R.id.game3score);
        gameScores[3] = findViewById(R.id.game4score);
        gameScores[4] = findViewById(R.id.game5score);

        getGame1Score();
        getGame2Score();
        getGame3Score();
        getGame4Score();
        getGame5Score();




    }


    private void getHighScore(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest strReq = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                int max;
                String username = "";
                int i = 1;
                System.out.println(response);
                try {
                    if(!response.isNull(0)) {
                        JSONObject cur = response.getJSONObject(0);
                        username = cur.getString("username");
                        max = cur.getInt("totalGamesPlayed");
                        while (!response.isNull(i)){
                            cur = response.getJSONObject(i);
                            int score = cur.getInt("totalGamesPlayed");
                            if (score > max) {
                                username = cur.getString("username");
                                max = score;
                            }
                            i++;
                        }
                        String ret =  username + ": " + max;
                        mostPlayedScore.setText(ret);
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });



        requestQueue.add(strReq);
    }

    private void getGame1Score(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest strReq = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                int max;
                String username = "";
                int i = 1;
                System.out.println(response);
                try {
                    if(!response.isNull(0)) {
                        JSONObject cur = response.getJSONObject(0);
                        username = cur.getString("username");
                        max = cur.getInt("game1score");
                        while (!response.isNull(i)){
                            cur = response.getJSONObject(i);
                            int score = cur.getInt("game1score");
                            if (score > max) {
                                username = cur.getString("username");
                                max = score;
                            }
                            i++;
                        }
                        String ret =  username + ": " + max;
                        gameScores[0].setText(ret);
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });



        requestQueue.add(strReq);
    }
    private void getGame2Score(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest strReq = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                int max;
                String username = "";
                int i = 1;
                System.out.println(response);
                try {
                    if(!response.isNull(0)) {
                        JSONObject cur = response.getJSONObject(0);
                        username = cur.getString("username");
                        max = cur.getInt("game2score");
                        while (!response.isNull(i)){
                            cur = response.getJSONObject(i);
                            int score = cur.getInt("game2score");
                            if (score > max) {
                                username = cur.getString("username");
                                max = score;
                            }
                            i++;
                        }
                        String ret =  username + ": " + max;
                        gameScores[1].setText(ret);
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });



        requestQueue.add(strReq);
    }

    private void getGame3Score(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest strReq = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                int max;
                String username = "";
                int i = 1;
                System.out.println(response);
                try {
                    if(!response.isNull(0)) {
                        JSONObject cur = response.getJSONObject(0);
                        username = cur.getString("username");
                        max = cur.getInt("game3score");
                        while (!response.isNull(i)){
                            cur = response.getJSONObject(i);
                            int score = cur.getInt("game3score");
                            if (score > max) {
                                username = cur.getString("username");
                                max = score;
                            }
                            i++;
                        }
                        String ret =  username + ": " + max;
                        gameScores[2].setText(ret);
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });



        requestQueue.add(strReq);
    }

    private void getGame4Score(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest strReq = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                int max;
                String username = "";
                int i = 1;
                System.out.println(response);
                try {
                    if(!response.isNull(0)) {
                        JSONObject cur = response.getJSONObject(0);
                        username = cur.getString("username");
                        max = cur.getInt("game4score");
                        while (!response.isNull(i)){
                            cur = response.getJSONObject(i);
                            int score = cur.getInt("game4score");
                            if (score > max) {
                                username = cur.getString("username");
                                max = score;
                            }
                            i++;
                        }
                        String ret =  username + ": " + max;
                        gameScores[3].setText(ret);
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });



        requestQueue.add(strReq);
    }

    private void getGame5Score(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest strReq = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                int max;
                String username = "";
                int i = 1;
                System.out.println(response);
                try {
                    if(!response.isNull(0)) {
                        JSONObject cur = response.getJSONObject(0);
                        username = cur.getString("username");
                        max = cur.getInt("game5score");
                        while (!response.isNull(i)){
                            cur = response.getJSONObject(i);
                            int score = cur.getInt("game5score");
                            if (score > max) {
                                username = cur.getString("username");
                                max = score;
                            }
                            i++;
                        }
                        String ret =  username + ": " + max;
                        gameScores[4].setText(ret);
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });



        requestQueue.add(strReq);
    }




}
