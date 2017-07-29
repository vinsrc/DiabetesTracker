package com.project.uwm.mydiabitiestracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.project.uwm.mydiabitiestracker.recordfragment.ExerciseRecordsFragment;
import com.project.uwm.mydiabitiestracker.recordfragment.FoodRecordsFragment;
import com.project.uwm.mydiabitiestracker.recordfragment.GlucoseRecordsFragment;
import com.project.uwm.mydiabitiestracker.recordfragment.PrescriptionRecordsFragment;

/**
 * Created by Anitha on 7/29/2017.
 */

public class ListMainRecords extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner menuSpinner;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewrecords);
        this.menuSpinner = (Spinner) findViewById(R.id.selectRecords);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.menu_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        menuSpinner.setAdapter(adapter);
        menuSpinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parentView, View view, int pos, long id) {
        String itemAtPosition =(String) parentView.getItemAtPosition(pos);
        if(itemAtPosition.equals("Food")){
            FoodRecordsFragment newFragment = new FoodRecordsFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.recordFragmentContainer, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();

        }else if(itemAtPosition.equals("Glucose")){
            GlucoseRecordsFragment newFragment = new GlucoseRecordsFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.recordFragmentContainer, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();

        }else if(itemAtPosition.equals("Exercise")){
            ExerciseRecordsFragment newFragment = new ExerciseRecordsFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.recordFragmentContainer, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();

        }else if(itemAtPosition.equals("Prescription")){
            PrescriptionRecordsFragment newFragment = new PrescriptionRecordsFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.recordFragmentContainer, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
