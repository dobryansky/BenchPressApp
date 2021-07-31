package com.artem.benchpressapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListFragment extends androidx.fragment.app.ListFragment {
    private WorkoutListener workoutListener;

    public ListFragment() {

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.weeks)));

        if (this.getActivity().findViewById(R.id.layout_default) == null) {
            workoutListener.onWorkoutItemListener(0);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            workoutListener = (WorkoutListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException((context.toString()) + "must implement interface called WorkoutListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        workoutListener.onWorkoutItemListener(position);
    }
}