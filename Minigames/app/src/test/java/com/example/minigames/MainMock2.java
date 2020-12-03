package com.example.minigames;

import org.json.JSONException;

public class MainMock2 {

    public MainMock2(){

    }

    public int trySaveSetting(String key, int setting, SettingsHandler settingsHandler) throws JSONException {

        if ((settingsHandler.getResponse(key, setting).getInt("Curt")==setting)) {
            return setting;
        }

        return setting;
    }
    public String trySaveKey(String key, int setting, SettingsHandler settingsHandler) throws JSONException {

        if ((settingsHandler.getResponse(key, setting).getString(key))==("Sound Effect")) {
            return key;
        }

        return key;
    }






}

