package com.project.uwm.mydiabitiestracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Anitha on 7/26/2017.
 */

public class FoodListActivity extends AppCompatActivity {
    ArrayList<FoodConsumedObject> foodList = new ArrayList<>();
    DatabaseManager dbManager = new DatabaseManager(this);
    private RecyclerView rvFood;
    private RecyclerView.Adapter fAdaptor;
    private RecyclerView.LayoutManager fLayoutManager;
    GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_food_recycleview);
        rvFood =(RecyclerView) findViewById(R.id.rvFoods);

        rvFood.setHasFixedSize(true);

        fLayoutManager = new LinearLayoutManager(this);
        rvFood.setLayoutManager(fLayoutManager);


        foodList = dbManager.selectFood();
        fAdaptor = new FoodAdapter(this, foodList);
        rvFood.setAdapter(fAdaptor);
    }


}