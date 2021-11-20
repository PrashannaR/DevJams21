package com.example.jobxregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class addUser extends AppCompatActivity {
    Button btnNext;
    ImageView addPhoto;
    EditText userName, address, phone, aadahar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        btnNext = findViewById(R.id.btnNext);
        addPhoto = findViewById(R.id.addPhoto);
        userName = findViewById(R.id.name);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        aadahar = findViewById(R.id.aadhaar);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkName() || !checkAddress() || !checkPhone() || !checkAadhar()){
                    return;
                }

                //get values
                String user = userName.getText().toString();
                String add = address.getText().toString();
                String ph = phone.getText().toString();
                String aadh = aadahar.getText().toString();

                Intent intent = new Intent(addUser.this, workDetails.class);
                //stores values
                intent.putExtra("User", user);
                intent.putExtra("Address", add);
                intent.putExtra("phone", ph);
                intent.putExtra("aadhar", aadh);

                startActivity(intent);

            }
        });

        //open camera
        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });
    }
    private boolean checkName(){
        String nameValue = userName.getText().toString().trim();
        if(nameValue.isEmpty()){
            userName.setError("Please enter the name");
            return false;
        }else {
            userName.setError(null);
            return true;
        }
    }

    private boolean checkAddress(){
        String addValue = address.getText().toString().trim();
        if(addValue.isEmpty()){
            address.setError("Please enter the name");
            return false;
        }else {
            address.setError(null);
            return true;
        }
    }

    private boolean checkPhone(){
        String phoneValue = phone.getText().toString().trim();
        if(phoneValue.isEmpty()){
            phone.setError("Please enter the name");
            return false;
        }else {
            phone.setError(null);
            return true;
        }
    }
    private boolean checkAadhar(){
        String aadharValue = aadahar.getText().toString().trim();
        if(aadharValue.isEmpty()){
            aadahar.setError("Please enter the name");
            return false;
        }else {
            aadahar.setError(null);
            return true;
        }
    }
}