package com.example.minigames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
/*
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;*/

import java.util.HashMap;
import java.util.Map;


public class SignUp extends AppCompatActivity {
    private String url = "";//TODO add url
    private TextView errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button submit = findViewById(R.id.submitButton);
        errorText = findViewById(R.id.errorMessage);
        //Switch login = findViewById(R.id.loginSwitch);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText usernameIN = findViewById(R.id.usernameInput);
                EditText passwordIN = findViewById(R.id.passwordInput);
                String username = usernameIN.getText().toString();
                String password = passwordIN.getText().toString();
                Switch login = findViewById(R.id.loginSwitch);
                final boolean loggingin = login.isChecked();
                String res = verifyInfo(username, password);
                //No error in input
                if(res == ""){
                    if(loggingin){
                        saveUserLocally(username);
                        openGameSelection();
                        //sendLoginRequest(username, password);
                    }
                    else{
                        saveUserLocally(username);
                        openGameSelection();
                        //sendSignupRequest(username, password);
                    }
                }
                else{
                    errorText.setText(res);
                }
            }
        });
    }
/*
    private void sendSignupRequest(final String username, final String password){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                errorText.setText(response);

                String correctRes = "New user " + username + " Saved";
                if(response != null && response.equals(correctRes)){
                    saveUserLocally(username);
                    openGameSelection();
                }


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                errorText.setText(error.toString());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> headers = new HashMap<>();
                headers.put("username", username);
                headers.put("password", password);
                return headers;
            }


        };

        requestQueue.add(strReq);
    }

    private void sendLoginRequest(final String username, final String password){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest strReq = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                errorText.setText(response);

                String correctRes = "Success";
                if(response != null && response.equals(correctRes)){
                    saveUserLocally(username);
                    openGameSelection();
                }


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                errorText.setText(error.toString());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> headers = new HashMap<>();
                headers.put("username", username);
                headers.put("password", password);
                return headers;
            }


        };

        requestQueue.add(strReq);
    }
*/
    private void openGameSelection(){
        Intent selectIntent = new Intent(getApplicationContext(), SelectScreen.class);
        startActivity(selectIntent);
    }

    private void saveUserLocally(String username){
        SharedPreferences sp = this.getSharedPreferences("appinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("loggedIN", true);
        editor.putString("username", username);
        editor.commit();
    }

    /**
     * Returns true if the password contains at least one uppercase letter,
     * lowercase letter, and a digit
     * @param password The password to be checked
     * @return
     */
    private boolean validPassword(String password){
        boolean req[] = {false,false,false};
        for(int i = 0; i < password.length(); i++){
            Character c = password.charAt(i);
            if(Character.isDigit(c)){
                req[0] = true;
            }
            else if(Character.isLowerCase(c)){
                req[1] = true;
            }
            else if(Character.isUpperCase(c)){
                req[2] = true;
            }
        }
        return (req[0] && req[1] && req[2]);
    }

    /**
     * Checks if the username and password and valid
     * @return A string containing "" if there are no errors,
     * otherwise a string containing the error messages corresponding to each input
     */
    private String verifyInfo(String username, String password) {
        String message = "";
        if(username.length() > 16 || username.length() < 4){
            message = message + "Username must be at least 4 characters long and no longer than 16 characters\n";
        }

        if(!validPassword(password)){
            message = message + "Password must contain at least 1 uppercase letter, lowercase letter, and a number\n";
        }

        return message;
    }
}
