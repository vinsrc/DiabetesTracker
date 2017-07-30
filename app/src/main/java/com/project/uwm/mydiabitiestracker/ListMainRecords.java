package com.project.uwm.mydiabitiestracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;

import com.project.uwm.mydiabitiestracker.recordfragment.ExerciseRecordsFragment;
import com.project.uwm.mydiabitiestracker.recordfragment.FoodRecordsFragment;
import com.project.uwm.mydiabitiestracker.recordfragment.GlucoseRecordsFragment;
import com.project.uwm.mydiabitiestracker.recordfragment.PrescriptionRecordsFragment;

/**
 * Created by Anitha on 7/29/2017.
 */

public class ListMainRecords extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner menuSpinner;
 /*   private static Switch selectorSwitch;*/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewrecords);
       /* selectorSwitch = (Switch) findViewById(R.id.switchSelectAllRecords);
        selectorSwitch.setChecked(false);*/
        this.menuSpinner = (Spinner) findViewById(R.id.selectRecords);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.menu_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        menuSpinner.setAdapter(adapter);
        menuSpinner.setOnItemSelectedListener(this);
    }

/*
    public static boolean returnSwitchStatus(){
        if(selectorSwitch.isChecked())
            return true;
        else
            return false;
    }
*/
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

    public void refreshFoodData(View v)
    {
        FoodRecordsFragment newFragment = new FoodRecordsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.recordFragmentContainer, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void foodToMain(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
