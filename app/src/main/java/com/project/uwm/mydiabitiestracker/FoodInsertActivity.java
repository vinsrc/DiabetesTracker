package com.project.uwm.mydiabitiestracker;
/**
 * Created by Anitha on 7/14/2017.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class FoodInsertActivity extends AppCompatActivity {
    private DatabaseManager dbManager;

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
        timefood.setText(df.format("hh:mm:ss a",date));

    }

    public void foodInsertDataBase( View v ) {
        EditText et_foodtypeamount = (EditText) findViewById(R.id.amount_food_value);
        EditText et_foodtype = (EditText) findViewById(R.id.foodtypevalue);
        EditText et_protienmeasure = (EditText) findViewById(R.id.protienvalue);
        EditText et_caloriesmeasure = (EditText) findViewById(R.id.caloriesvalue);
        EditText et_timemeasure = (EditText) findViewById(R.id.time_value_f);
        EditText et_datemeasure = (EditText) findViewById(R.id.date_value_f);
        String timeString = et_timemeasure.getText().toString();
        String dateString = et_datemeasure.getText().toString();

        String foodtypeamount = et_foodtypeamount.getText().toString();
        String foodtype = et_foodtype.getText().toString();
        String caloriesString = et_caloriesmeasure.getText().toString();
        String protienString = et_protienmeasure.getText().toString();

        int amountOfFood = Integer.parseInt(foodtypeamount);
        int protien = Integer.parseInt(protienString);
        int calories = Integer.parseInt(caloriesString);
        //String date = Integer.parseInt(dateString);
        //String time = Integer.parseInt(timeString);
        try{
            FoodConsumedObject fco = new FoodConsumedObject( 0,foodtype, amountOfFood, protien, calories, dateString,null );

            dbManager.inserFood(fco);
            Toast.makeText( this, "Detils added", Toast.LENGTH_SHORT ).show( );
        } catch ( NumberFormatException nfe ) {
            Toast.makeText( this, "Food Insert error", Toast.LENGTH_LONG ).show( );
        }
        et_foodtypeamount.setText("");
        et_foodtype.setText("");
        et_caloriesmeasure.setText("");
        et_protienmeasure.setText("");
    }
 /*   void onFoodClicked (View v){
        Intent intent = new Intent(this,FoodActivity.class);
        this.startActivity(intent);
    }*/
    public void goBack(View view){
        this.finish();
    }
}