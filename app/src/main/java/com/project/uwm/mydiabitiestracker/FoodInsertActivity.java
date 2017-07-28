package com.project.uwm.mydiabitiestracker;


/**
 * Created by Anitha on 7/14/2017.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class FoodInsertActivity extends AppCompatActivity {
    private DatabaseManager dbManager;
    public static final String FI = "FoodInsertActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_insert);
        dbManager = new DatabaseManager(this);
        Date date = new Date();
        EditText datefood = (EditText) findViewById(R.id.date_value_f);
        android.text.format.DateFormat df = new android.text.format.DateFormat();
        datefood.setText(df.format("yyyy-MM-dd",date));
        EditText timefood = (EditText) findViewById(R.id.time_value_f);
        timefood.setText(df.format("hh:mm:ss",date));
    }
    protected void onStart() {
        super.onStart();
        Log.w(FI, "inside FoodInsertActivity:onStart()\n");
    }
    protected void onRestart() {
        super.onRestart();
        Log.v(FI, "inside FoodInsertActivity:onRestart()\n");
    }
    protected void onResume() {
        super.onResume();
        Log.v(FI, "inside FoodInsertActivity:onResume()\n");
    }
    protected void onPause() {
        super.onPause();
        Log.v(FI, "inside FoodInsertActivity:onPause()\n");
    }
    protected void onStop() {
        super.onStop();
        Log.v(FI, "inside FoodInsertActivity:onStop()\n");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.v(FI, "inside FoodInsertActivity:onDestroy()\n");
    }

    public void foodInsertDataBase( View v ) {
        EditText et_foodtypeamount = (EditText) findViewById(R.id.amount_food_value);
        EditText et_foodtype = (EditText) findViewById(R.id.foodtypevalue);
        EditText et_proteinmeasure = (EditText) findViewById(R.id.protein_value);
        EditText et_caloriesmeasure = (EditText) findViewById(R.id.calories_value);
        EditText et_timemeasure = (EditText) findViewById(R.id.time_value_f);
        EditText et_datemeasure = (EditText) findViewById(R.id.date_value_f);
        String timeString = et_timemeasure.getText().toString();
        String dateString = et_datemeasure.getText().toString();

        String foodtypeamount = et_foodtypeamount.getText().toString();
        String foodtype = et_foodtype.getText().toString();
        String caloriesString = et_caloriesmeasure.getText().toString();
        String proteinString = et_proteinmeasure.getText().toString();

        int amountOfFood = Integer.parseInt(foodtypeamount);
        int protein = Integer.parseInt(proteinString);
        int calories = Integer.parseInt(caloriesString);
        //String date = Integer.parseInt(dateString);
        //String time = Integer.parseInt(timeString);
        try{
            FoodConsumedObject fco = new FoodConsumedObject( 0,foodtype, amountOfFood, protein, calories, dateString,timeString );

            dbManager.insertFood(fco);
            Toast.makeText( this, "Details added", Toast.LENGTH_SHORT ).show( );
        } catch ( NumberFormatException nfe ) {
            Toast.makeText( this, "Food Insert error", Toast.LENGTH_LONG ).show( );
        }
        et_foodtypeamount.setText("");
        et_foodtype.setText("");
        et_caloriesmeasure.setText("");
        et_proteinmeasure.setText("");
        et_foodtype.requestFocus();
        dbManager.close();
    }
 /*   void onFoodClicked (View v){
        Intent intent = new Intent(this,FoodActivity.class);
        this.startActivity(intent);
    }*/
    public void goBack(View view){
        this.finish();
    }
}