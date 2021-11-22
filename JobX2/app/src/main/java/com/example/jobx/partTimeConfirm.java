package com.example.jobx;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class partTimeConfirm extends AppCompatActivity {

    TextView nametext, occupationText, years, partTime, fullTime, aadhar, totalTime,number;
    EditText hours;

    Button btnCalculate, btnContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_time_confirm);

        nametext = findViewById(R.id.nametext);
        occupationText = findViewById(R.id.occupationText);
        years = findViewById(R.id.years);
        partTime = findViewById(R.id.partTime);
        fullTime = findViewById(R.id.fullTime);
        aadhar = findViewById(R.id.aadhar);
        number = findViewById(R.id.number);
        hours = findViewById(R.id.hours);
        totalTime = findViewById(R.id.totalTime);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnContact = findViewById(R.id.btnContact);


        //get values
        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        String occupation = intent.getStringExtra("occupation");
        String nYears = intent.getStringExtra("years");
        String nPartTime = intent.getStringExtra("partTime");
        String nFullTime = intent.getStringExtra("fullTime");
        String nAadhar = intent.getStringExtra("aadhar");
        String nNumber = intent.getStringExtra("number");

        nametext.setText(user);
        occupationText.setText(occupation);
        years.setText(nYears);
        partTime.setText(nPartTime);
        fullTime.setText(nFullTime);
        aadhar.setText(nAadhar);
        number.setText(nNumber);



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int intHours = Integer.parseInt(hours.getText().toString());
                int  intPayHour = Integer.parseInt(nPartTime);
                int mul = intHours * intPayHour;
                totalTime.setText("The total is: " + String.valueOf(mul));

            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent value = new Intent(getApplicationContext(), ContactEmployee.class);
                value.putExtra("user", nametext.getText().toString());
                value.putExtra("occupation", occupationText.getText().toString());
                value.putExtra("years", years.getText().toString());
                value.putExtra("partTime", partTime.getText().toString());
                value.putExtra("fullTime", fullTime.getText().toString());
                value.putExtra("aadhar", aadhar.getText().toString());
                value.putExtra("number", number.getText().toString());
                startActivity(value);


            }
        });




    }
}