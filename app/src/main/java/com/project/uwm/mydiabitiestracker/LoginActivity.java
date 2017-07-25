package com.project.uwm.mydiabitiestracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Anitha on 7/9/2017.
 */

public class LoginActivity extends AppCompatActivity {
    Button login_button;
    EditText userName, passWord;
    String user , password;
    UserObject preference;
    private static final String USER_KEY = "userKey";
    private static final String PASSWORD_KEY ="passwordKey";
    private static final String USER_DETAILS ="userDetails";
    UserPreference pref;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       pref = new UserPreference(this);
        setContentView(R.layout.login_main);
     /*   userName.setText(pref.getUserName());
        passWord.setText(pref.getPassword());*/
   /*   *//*  SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        userName.setText(pref.getString(USER_KEY,"a"));
        passWord.setText(pref.getString(PASSWORD_KEY,"a"));*//*
        SharedPreferences pref =PreferenceManager.getDefaultSharedPreferences(this);
        user = pref.getString(USER_KEY,"a");
        password = pref.getString(PASSWORD_KEY,"a");*/

    }

    public void onStart( ) {
        super.onStart( );
        updateView( );
    }
    public void updateView(){
        passWord = (EditText) findViewById(R.id.hint_user);
        userName =(EditText) findViewById(R.id.hint_password);
        passWord.setText(pref.getPassword());
        userName.setText(pref.getUserName());
    }


    public void verifyLogin(View v){
  /*      SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        userName.setText(pref.getString(USER_KEY,"name"));
        passWord.setText(pref.getString(PASSWORD_KEY,"password"));*/


        passWord = (EditText) findViewById(R.id.hint_user);
        userName =(EditText) findViewById(R.id.hint_password);

        String userNameString = userName.getText().toString().trim();
        String passWordString = passWord.getText().toString().trim();
        pref.setUserName(userNameString);
        pref.setPassword(passWordString);
        pref.setPreference(this);
        DatabaseManager dbManager = new DatabaseManager(this);

       /* SharedPreferences preferences = getSharedPreferences(USER_DETAILS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USER_KEY, userName.getText().toString());
        editor.putString(PASSWORD_KEY, passWord.getText().toString());
        editor.putString("logged", "logged");
        editor.commit();*/

        int statusUser = dbManager.verifyLogin(userNameString,passWordString);
        if (statusUser <= 0) {
            clearText();
            Toast.makeText(this, "UserName/Password is incorrect! Please try again!" , Toast.LENGTH_LONG).show();
        }else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void clearText() {
        userName.setText("");
        passWord.setText("");
        userName.requestFocus();
    }
    public void userCreate(View v){
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }
}