package com.example.jobx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class electricianView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrician);

        getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new recfragmentElectrician()).commit();
    }
}