package com.project.uwm.mydiabitiestracker.insertion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.project.uwm.mydiabitiestracker.DatabaseManager;
import com.project.uwm.mydiabitiestracker.R;
import com.project.uwm.mydiabitiestracker.objects.ExerciseReadingObject;

import java.util.Date;

/**
 * Created by Ron on 7-23-2017
 */

public class ExerciseActivity extends AppCompatActivity {
    private DatabaseManager dbManager;
    public static final String EA = "ExerciseActivity";

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        Date date = new Date();
        EditText dateOfExercise = (EditText) findViewById(R.id.exercise_date_value);
        android.text.format.DateFormat df = new android.text.format.DateFormat();
        dateOfExercise.setText(df.format("yyyy-MM-dd",date));
        EditText startTimeOfExercise = (EditText) findViewById(R.id.exercise_start_time_value);
        startTimeOfExercise.setText(df.format("hh:mm:ss a",date));
    }
    protected void onStart() {
        super.onStart();
        Log.w(EA, "inside ExerciseActivity:onStart()\n");
    }
    protected void onRestart() {
        super.onRestart();
        Log.v(EA, "inside ExerciseActivity:onRestart()\n");
    }
    protected void onResume() {
        super.onResume();
        Log.v(EA, "inside ExerciseActivity:onResume()\n");
    }
    protected void onPause() {
        super.onPause();
        Log.v(EA, "inside ExerciseActivity:onPause()\n");
    }
    protected void onStop() {
        super.onStop();
        Log.v(EA, "inside ExerciseActivity:onStop()\n");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.v(EA, "inside ExerciseActivity:onDestroy()\n");
    }
    
    public void exerciseInsert(View v) {
        dbManager = new DatabaseManager(this);
        EditText typeOfExercise = (EditText) findViewById(R.id.exercise_type_value);
        EditText minutesOfExercise = (EditText) findViewById(R.id.exercise_duration_value);
        EditText dateOfExercise = (EditText) findViewById(R.id.exercise_date_value);
        EditText startTimeOfExercise = (EditText) findViewById(R.id.exercise_start_time_value);
        String timeString = startTimeOfExercise.getText().toString();
        String dateString = dateOfExercise.getText().toString();
        String typeOfExerciseString = typeOfExercise.getText().toString();
        int minutesOfExerciseInt = Integer.parseInt(minutesOfExercise.getText().toString());

        try{
            ExerciseReadingObject eco = new ExerciseReadingObject(
                    0,
                    minutesOfExerciseInt,
                    typeOfExerciseString,
                    dateString,
                    timeString );
            dbManager.insertExercise(eco);
            Toast.makeText( this, "Details added", Toast.LENGTH_SHORT ).show( );
        } catch ( NumberFormatException nfe ) {
            Toast.makeText( this, "Food Insert error", Toast.LENGTH_LONG ).show( );
        }
        typeOfExercise.setText("");
        minutesOfExercise.setText("");
        typeOfExercise.requestFocus();
        dbManager.close();

    }
    public void goBack(View view){
        this.finish();
    }

}