package com.project.uwm.mydiabitiestracker.insertion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.project.uwm.mydiabitiestracker.DatabaseManager;
import com.project.uwm.mydiabitiestracker.R;
import com.project.uwm.mydiabitiestracker.objects.PrescriptionReadingObject;

import java.util.Date;

/**
 * Created by Ron on 7-23-2017
 */

public class PrescriptionActivity extends AppCompatActivity {
    private DatabaseManager dbManager;
    private EditText dateTaken;
    private EditText timeTaken;
    public static final String PA = "PrescriptionActivity";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);
        Date date = new Date();
        EditText dateTaken = (EditText) findViewById(R.id.date_administered_value);
        android.text.format.DateFormat df = new android.text.format.DateFormat();
        dateTaken.setText(df.format("yyyy-MM-dd", date));
        EditText timeTaken = (EditText) findViewById(R.id.time_administered_value);
        timeTaken.setText(df.format("hh:mm:ss a", date));
        EditText p_type = (EditText) findViewById(R.id.prescription_type_value);
        p_type.requestFocus();

    }
    protected void onStart() {
        super.onStart();
        Log.w(PA, "inside PrescriptionActivity:onStart()\n");
    }
    protected void onRestart() {
        super.onRestart();
        Log.v(PA, "inside PrescriptionActivity:onRestart()\n");
    }
    protected void onResume() {
        super.onResume();
        Log.v(PA, "inside PrescriptionActivity:onResume()\n");
    }
    protected void onPause() {
        super.onPause();
        Log.v(PA, "inside PrescriptionActivity:onPause()\n");
    }
    protected void onStop() {
        super.onStop();
        Log.v(PA, "inside PrescriptionActivity:onStop()\n");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.v(PA, "inside PrescriptionActivity:onDestroy()\n");
    }

    public void prescriptionInsert(View v) {
        dbManager = new DatabaseManager(this);
        EditText drugName = (EditText) findViewById(R.id.prescription_type_value);
        EditText prescriptionDose = (EditText) findViewById(R.id.dosage_value);
        EditText dateTaken = (EditText) findViewById(R.id.date_administered_value);
        EditText timeTaken = (EditText) findViewById(R.id.time_administered_value);
        String timeString = timeTaken.getText().toString();
        String dateString = dateTaken.getText().toString();
        String drugNameString = drugName.getText().toString();
        int doseInt = Integer.parseInt(prescriptionDose.getText().toString());

        try {
            PrescriptionReadingObject pro = new PrescriptionReadingObject(0, doseInt, drugNameString, dateString, timeString);
            dbManager.insertPrescription(pro);
            Toast.makeText(this, "Details added", Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException nfe) {
            Toast.makeText(this, "Food Insert error", Toast.LENGTH_LONG).show();
        }
        drugName.setText("");
        prescriptionDose.setText("");
        dbManager.close();
    }
    public void goBack(View view){
        this.finish();
    }
}


