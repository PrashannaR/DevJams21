package com.example.jobx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VerifyEmployee extends AppCompatActivity {

    EditText input1, input2, input3, input4, input5, input6;
    TextView nametext, occupationText, years, partTime, fullTime, aadhar, number;
    Button btnVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_employee);

        nametext = findViewById(R.id.nametext);
        occupationText = findViewById(R.id.occupationText);
        years = findViewById(R.id.years);
        partTime = findViewById(R.id.partTime);
        fullTime = findViewById(R.id.fullTime);
        aadhar = findViewById(R.id.aadhar);
        number = findViewById(R.id.number);

        //get values
        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        String occupation = intent.getStringExtra("occupation");
        String nYears = intent.getStringExtra("years");
        String nPartTime = intent.getStringExtra("partTime");
        String nFullTime = intent.getStringExtra("fullTime");
        String nAadhar = intent.getStringExtra("aadhar");
        String nNumber = intent.getStringExtra("number");

        //set values
        nametext.setText(user);
        occupationText.setText(occupation);
        years.setText(nYears);
        partTime.setText(nPartTime);
        fullTime.setText(nFullTime);
        aadhar.setText(nAadhar);
        number.setText(nNumber);


        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);
        input4 = findViewById(R.id.input4);
        input5 = findViewById(R.id.input5);
        input6 = findViewById(R.id.input6);

        btnVerify = findViewById(R.id.btnVerify);

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkOTPOne() || !checkOTPTwo() || !checkOTPThree() || !checkOTPFour() || !checkOTPFive() || !checkOTPSix()) {
                    return;
                }

            }
        });

        OPTMove();

    }

    private boolean checkOTPOne() {
        String one = input1.getText().toString().trim();
        if (one.isEmpty()) {
            input1.setError("Fill in the OTP");
            return false;
        } else {
            input1.setError(null);
            return true;
        }


    }

    private boolean checkOTPTwo() {
        String two = input2.getText().toString().trim();
        if (two.isEmpty()) {
            input2.setError("Fill in the OTP");
            return false;
        } else {
            input2.setError(null);
            return true;
        }


    }

    private boolean checkOTPThree() {
        String three = input3.getText().toString().trim();
        if (three.isEmpty()) {
            input3.setError("Fill in the OTP");
            return false;
        } else {
            input3.setError(null);
            return true;
        }


    }

    private boolean checkOTPFour() {
        String four = input4.getText().toString().trim();
        if (four.isEmpty()) {
            input4.setError("Fill in the OTP");
            return false;
        } else {
            input4.setError(null);
            return true;
        }


    }

    private boolean checkOTPFive() {
        String five = input5.getText().toString().trim();
        if (five.isEmpty()) {
            input5.setError("Fill in the OTP");
            return false;
        } else {
            input5.setError(null);
            return true;
        }


    }

    private boolean checkOTPSix() {
        String six = input6.getText().toString().trim();
        if (six.isEmpty()) {
            input6.setError("Fill in the OTP");
            return false;
        } else {
            input6.setError(null);
            return true;
        }


    }

    private void OPTMove() {
        input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    input2.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        input2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    input3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        input3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    input4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        input4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    input5.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        input5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    input6.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}