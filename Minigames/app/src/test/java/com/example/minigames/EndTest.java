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


public class EndTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();


    @Test
    public void getKeyTest() throws JSONException {
        EndHandler test = mock(EndHandler.class);
        MainMock3 testKeySuccess = new MainMock3();

        String key = "perfect";
        int result = 10;

        JSONObject mock = Mockito.mock(JSONObject.class);

        mock.put(key,result);


        when(test.getResponse(key,result)).thenReturn(mock);
        Assert.assertEquals(testKeySuccess.tryGetKey(key,result,test),key);
    }
    @Test
    public void getResultTest() throws JSONException {

        EndHandler test = mock(EndHandler.class);
        MainMock3 testEndSuccess = new MainMock3();

        String key = "perfect";
        int result = 10;

        JSONObject mock = Mockito.mock(JSONObject.class);

        mock.put(key,result);


        when(test.getResponse(key,result)).thenReturn(mock);
        Assert.assertEquals(testEndSuccess.tryGetResult(key,result,test),result);

    }
    @Test
    public void getResultTest2() throws JSONException {

        EndHandler test = mock(EndHandler.class);
        MainMock3 testEndSuccess = new MainMock3();

        String key = "great";
        int result = 10;

        JSONObject mock = Mockito.mock(JSONObject.class);

        mock.put(key,result);


        when(test.getResponse(key,result)).thenReturn(mock);
        Assert.assertEquals(testEndSuccess.tryGetResults(key,result,test),result);

    }

}