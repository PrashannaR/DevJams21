package com.example.jobx;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class recfragmentElectrician extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    //view
    RecyclerView recView;

    myAdaptarClassElectrician adaptarClassElectrician;


    public recfragmentElectrician() {
    }


    public static recfragmentElectrician newInstance(String param1, String param2) {
        recfragmentElectrician fragment = new recfragmentElectrician();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //added view and hooked recycler view
       View view =   inflater.inflate(R.layout.fragment_recfragment, container, false);

       recView = (RecyclerView)view.findViewById(R.id.recView);
       recView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("employees"), model.class)
                        .build();
        adaptarClassElectrician = new myAdaptarClassElectrician(options);
        recView.setAdapter(adaptarClassElectrician);
       return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adaptarClassElectrician.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adaptarClassElectrician.stopListening();
    }
}