package com.example.jobx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContactEmployee extends AppCompatActivity {
    TextView nametext, occupationText, years, partTime, fullTime, aadhar, number;
    EditText details, receiverNumber;
    Button btnSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_employee);

        nametext = findViewById(R.id.nametext);
        occupationText = findViewById(R.id.occupationText);
        years = findViewById(R.id.years);
        partTime = findViewById(R.id.partTime);
        fullTime = findViewById(R.id.fullTime);
        aadhar = findViewById(R.id.aadhar);
        number = findViewById(R.id.number);
        receiverNumber = findViewById(R.id.receiverNumber);
        details = findViewById(R.id.details);
        btnSend = findViewById(R.id.btnSend);


        //get values
        Intent value = getIntent();
        String user = value.getStringExtra("user");
        String occupation = value.getStringExtra("occupation");
        String nYears = value.getStringExtra("years");
        String nPartTime = value.getStringExtra("partTime");
        String nFullTime = value.getStringExtra("fullTime");
        String nAadhar = value.getStringExtra("aadhar");
        String nNumber = value.getStringExtra("number");

        //set values
        nametext.setText(user);
        occupationText.setText(occupation);
        years.setText(nYears);
        partTime.setText(nPartTime);
        fullTime.setText(nFullTime);
        aadhar.setText(nAadhar);
        number.setText(nNumber);

      //  receiverNumber.setText(nNumber);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int permissionCheck = ContextCompat.checkSelfPermission(ContactEmployee.this, Manifest.permission.SEND_SMS);

                if(permissionCheck == PackageManager.PERMISSION_GRANTED){
                    MyMessage();
                }else {
                    ActivityCompat.requestPermissions(ContactEmployee.this, new String[]{Manifest.permission.SEND_SMS}, 0);
                }
               /* Intent intent = new Intent(getApplicationContext(), EmployeeVerification.class);
                intent.putExtra("user", nametext.getText().toString());
                intent.putExtra("occupation", occupationText.getText().toString());
                intent.putExtra("years", years.getText().toString());
                intent.putExtra("partTime", partTime.getText().toString());
                intent.putExtra("fullTime", fullTime.getText().toString());
                intent.putExtra("aadhar", aadhar.getText().toString());
                intent.putExtra("number", number.getText().toString());
                startActivity(intent);*/
            }

        });


    }



    private void MyMessage() {
        String phoneNumber = receiverNumber.getText().toString().trim();
        String Message = details.getText().toString().trim();

        if(!phoneNumber.equals("") || !Message.equals("")){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, Message, null, null);
            Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show();

          /*  Intent intent = new Intent(getApplicationContext(), VerifyEmployee.class);
            intent.putExtra("user", nametext.getText().toString());
            intent.putExtra("occupation", occupationText.getText().toString());
            intent.putExtra("years", years.getText().toString());
            intent.putExtra("partTime", partTime.getText().toString());
            intent.putExtra("fullTime", fullTime.getText().toString());
            intent.putExtra("aadhar", aadhar.getText().toString());
            intent.putExtra("number", number.getText().toString());
            startActivity(intent);*/

        }else {
            Toast.makeText(this, "Please fill in the details correctly", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 0) {
            if (grantResults.length >= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                MyMessage();
            }
        }
    }
}