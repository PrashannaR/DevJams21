package com.example.jobx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class fullTimeConfirm extends AppCompatActivity {
    TextView nametext, occupationText, years, partTime, fullTime, aadhar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_time_confirm);

        nametext = findViewById(R.id.nametext);
        occupationText = findViewById(R.id.occupationText);
        years = findViewById(R.id.years);
        partTime = findViewById(R.id.partTime);
        fullTime = findViewById(R.id.fullTime);
        aadhar = findViewById(R.id.aadhar);

        //get values
        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        String occupation = intent.getStringExtra("occupation");
        String nYears = intent.getStringExtra("years");
        String nPartTime = intent.getStringExtra("partTime");
        String nFullTime = intent.getStringExtra("fullTime");
        String nAadhar = intent.getStringExtra("aadhar");

        nametext.setText(user);
        occupationText.setText(occupation);
        years.setText(nYears);
        partTime.setText(nPartTime);
        fullTime.setText(nFullTime);
        aadhar.setText(nAadhar);
    }
}