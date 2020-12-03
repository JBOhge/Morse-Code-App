
package com.example.minigames;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class LeaderTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();


    @Test
    public void getScoreTest() throws JSONException {
        ScoreHandler test = mock(ScoreHandler.class);
        MainMock testScoreSuccess = new MainMock();

        String username = "user";
        int score = 10;

        JSONObject mock = Mockito.mock(JSONObject.class);

        mock.put(username,score);


        when(test.getResponse(username,score)).thenReturn(mock);
        Assert.assertEquals(testScoreSuccess.trySendScore(username,score,test),score);

    }
    @Test
    public void getNameTest() throws JSONException {
        ScoreHandler test = mock(ScoreHandler.class);
        MainMock testNameSuccess = new MainMock();

        String username = "Curt";
        int score = 100;

        JSONObject mock = Mockito.mock(JSONObject.class);

        mock.put(username,score);


        when(test.getResponse(username,score)).thenReturn(mock);
        Assert.assertEquals(testNameSuccess.trySendName(username,score,test),username);

    }


}

