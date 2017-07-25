package com.project.uwm.mydiabitiestracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Anitha on 7/23/2017.
 */
 public class AddActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_main);
    }

    public void foodInsert(View v) {
        Intent intent = new Intent(this, FoodInsertActivity.class);
        startActivity(intent);
    }
    public void glucoseInsert(View v){
        Intent intent = new Intent(this, GlucoseInsertActivity.class);
        startActivity(intent);
    }




}