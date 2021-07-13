package com.artem.benchpressapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity implements WorkoutListener {

     TextView txtDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtDetails=(TextView) findViewById(R.id.workoutDetail);


    }

    @Override
    public void onWorkoutItemListener(int index) {
        String[] descriptions = getResources().getStringArray(R.array.descriptions);
        txtDetails.setText(descriptions[index]);
        


    }
}