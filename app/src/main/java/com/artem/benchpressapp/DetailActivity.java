package com.artem.benchpressapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailActivity extends AppCompatActivity implements WorkoutListener {


    private List<Exercise> listExercise = new ArrayList<>();
    TextView txtWeek,txtDay;
    //ArrayList<Exercise> exercises=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initData();
        initViews();

        if(findViewById(R.id.layout_default)!=null){
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.fragmentContainerDetail))
                    .show(manager.findFragmentById(R.id.fragmentContainerList))
                    .commit();
        }

        if(findViewById(R.id.layout_land)!=null){
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragmentContainerDetail))
                    .show(manager.findFragmentById(R.id.fragmentContainerList))
                    .commit();        }


    }

    @Override
    public void onWorkoutItemListener(int index) {

        if(findViewById(R.id.layout_default)!=null){
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragmentContainerDetail))
                    .hide(manager.findFragmentById(R.id.fragmentContainerList))
                    .addToBackStack(null)
                    .commit();
        }

        TextView textExercise,textWeight,textSets,textReps,textDay;
        final TableLayout detailsTable = (TableLayout) findViewById(R.id.mainTable);
        boolean day1=true;
        boolean day2=true;
        boolean day3=true;

        detailsTable.removeAllViews();
        for (int i = 0; i < listExercise.size(); i++) {

          if(listExercise.get(i).getWeek().equals("Week "+ (index+1))){
              final TableRow tableRowOne = (TableRow) getLayoutInflater().inflate(R.layout.table_row_one, null);
              textDay = (TextView) tableRowOne.findViewById(R.id.textDay);

              textDay.setText(listExercise.get(i).getDay());
              if(listExercise.get(i).getDay().equals("день 1")) {

                  final TableRow tableRow = (TableRow) getLayoutInflater().inflate(R.layout.table_row, null);


                  textExercise = (TextView) tableRow.findViewById(R.id.textExercise);
                  textExercise.setText(listExercise.get(i).getName());

                  textWeight = (TextView) tableRow.findViewById(R.id.textWeight);
                  textWeight.setText(listExercise.get(i).getWeight());

                  textSets = (TextView) tableRow.findViewById(R.id.textSets);
                  textSets.setText(listExercise.get(i).getSets());

                  textReps = (TextView) tableRow.findViewById(R.id.textReps);
                  textReps.setText(listExercise.get(i).getReps());
if (day1) {
    detailsTable.addView(tableRowOne);
    day1=false;
}


                  detailsTable.addView(tableRow);
              }

              //textDay = (TextView) tableRowOne.findViewById(R.id.textDay);
              textDay.setText(listExercise.get(i).getDay());

              if(listExercise.get(i).getDay().equals("день 2")) {

                  final TableRow tableRow = (TableRow) getLayoutInflater().inflate(R.layout.table_row, null);
                 // final TableRow tableRowOne = (TableRow) getLayoutInflater().inflate(R.layout.table_row_one, null);


                  textExercise = (TextView) tableRow.findViewById(R.id.textExercise);
                  textExercise.setText(listExercise.get(i).getName());

                  textWeight = (TextView) tableRow.findViewById(R.id.textWeight);
                  textWeight.setText(listExercise.get(i).getWeight());

                  textSets = (TextView) tableRow.findViewById(R.id.textSets);
                  textSets.setText(listExercise.get(i).getSets());

                  textReps = (TextView) tableRow.findViewById(R.id.textReps);
                  textReps.setText(listExercise.get(i).getReps());

                  if (day2) {
                      detailsTable.addView(tableRowOne);
                      day2=false;
                  }

                  detailsTable.addView(tableRow);
              }
             // textDay = (TextView) tableRowOne.findViewById(R.id.textDay);
              textDay.setText(listExercise.get(i).getDay());

              if(listExercise.get(i).getDay().equals("день 3")) {

                  final TableRow tableRow = (TableRow) getLayoutInflater().inflate(R.layout.table_row, null);
                  //final TableRow tableRowOne = (TableRow) getLayoutInflater().inflate(R.layout.table_row_one, null);



                  textExercise = (TextView) tableRow.findViewById(R.id.textExercise);
                  textExercise.setText(listExercise.get(i).getName());

                  textWeight = (TextView) tableRow.findViewById(R.id.textWeight);
                  textWeight.setText(listExercise.get(i).getWeight());

                  textSets = (TextView) tableRow.findViewById(R.id.textSets);
                  textSets.setText(listExercise.get(i).getSets());

                  textReps = (TextView) tableRow.findViewById(R.id.textReps);
                  textReps.setText(listExercise.get(i).getReps());


                  if (day3) {
                      detailsTable.addView(tableRowOne);
                      day3=false;
                  }
                  detailsTable.addView(tableRow);
              }

          }
        }




       txtWeek.setText(getResources().getStringArray(R.array.weeks)[index]);





    }


    private void initData() {
        InputStream is= getResources().openRawResource(R.raw.datanew);
        BufferedReader reader= new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

        String line="";
        try {
            while ((line = reader.readLine()) != null) {
//
                String[] splitLines= line.split(";");
                listExercise.add(new Exercise(splitLines[0],splitLines[1],splitLines[2],splitLines[3],splitLines[4],splitLines[5]));
            }
        }
        catch (IOException e){
            Log.wtf("My Activity","Error reading data file on line"+line,e);
            e.printStackTrace();
        }




    }

    private void initViews() {
       /* textExercise=findViewById(R.id.textExercise);
        textWeight=findViewById(R.id.textWeight);
        textSets=findViewById(R.id.textSets);
        textReps=findViewById(R.id.textReps);*/
        txtWeek=findViewById(R.id.txtWeek);

    }

}