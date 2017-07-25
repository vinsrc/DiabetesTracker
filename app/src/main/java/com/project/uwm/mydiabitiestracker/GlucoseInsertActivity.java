package com.project.uwm.mydiabitiestracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by Anitha on 7/15/2017.
 */

public class GlucoseInsertActivity extends AppCompatActivity {
    private DatabaseManager dbManager;

        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.glucose_insert);
            Date date = new Date();
            EditText dateglu = (EditText) findViewById(R.id.date_value);
            android.text.format.DateFormat df = new android.text.format.DateFormat();
            dateglu.setText(df.format("yyyy-MM-dd",date));
            EditText timeglu = (EditText) findViewById(R.id.time_value);
            timeglu.setText(df.format("hh:mm:ss a",date));
        }
        public void glucoseInsert(View v) {
            dbManager = new DatabaseManager(this);
            EditText glucoseValue = (EditText) findViewById(R.id.glucose_value);
            EditText readingTaken = (EditText) findViewById(R.id.reading_taken_value);
            EditText dateglu = (EditText) findViewById(R.id.date_value);
            EditText timeglu = (EditText) findViewById(R.id.time_value);
            String timeString = timeglu.getText().toString();
            String dateString = dateglu.getText().toString();
            String sReadingTaken = readingTaken.getText().toString();
            int iGlucoseValue = Integer.parseInt(glucoseValue.getText().toString());

            try{
                GlucoseReadingObject gco = new GlucoseReadingObject( 0,iGlucoseValue,sReadingTaken,dateString,timeString );
                dbManager.insertGlucose(gco);
                Toast.makeText( this, "Detils added", Toast.LENGTH_SHORT ).show( );
            } catch ( NumberFormatException nfe ) {
                Toast.makeText( this, "Food Insert error", Toast.LENGTH_LONG ).show( );
            }
            glucoseValue.setText("");
            readingTaken.setText("");

        }
        public void goBack(){
            this.finish();
        }

    }

