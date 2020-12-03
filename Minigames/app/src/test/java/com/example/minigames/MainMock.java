package com.example.minigames;

import org.json.JSONException;

public class MainMock {

    public MainMock(){

    }

    public int trySendScore(String username, int score, ScoreHandler scoreHandler) throws JSONException {

        if ((scoreHandler.getResponse(username, score).getInt("Curt")==score)) {
            return score;
        }

        return score;
    }
    public String trySendName(String username, int score, ScoreHandler scoreHandler) throws JSONException {

        if ((scoreHandler.getResponse(username, score).getString(username))=="Curt") {
            return username;
        }

        return username;
    }






}

