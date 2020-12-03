package com.example.minigames;

import org.json.JSONException;

public class MainMock3 {

    public MainMock3(){

    }

    public int tryGetResult(String key, int result, EndHandler endHandler) throws JSONException {

        if ((endHandler.getResponse(key, result).getInt("perfect")==result)) {
            return result;
        }

        return result;
    }
    public String tryGetKey(String key, int result, EndHandler endHandler) throws JSONException {

        if ((endHandler.getResponse(key, result).getString(key))==(key)) {
            return key;
        }

        return key;
    }
    public int tryGetResults(String key, int result, EndHandler endHandler) throws JSONException {

        if ((endHandler.getResponse(key, result).getInt("perfect")==result)&&(endHandler.getResponse(key, result).getString(key))==(key)) {
            return result;
        }

        return result;
    }







}