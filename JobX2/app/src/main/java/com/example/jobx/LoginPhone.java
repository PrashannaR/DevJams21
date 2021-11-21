package com.example.jobx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginPhone extends AppCompatActivity {

    Button btnNext;
    EditText phone, password;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://jobx-e4dcb-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phone);

        btnNext = findViewById(R.id.btnNext);

        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(getApplicationContext(), LoginOTP.class));

                String phoneNo = phone.getText().toString();
                String pw = password.getText().toString();

                if(phoneNo.isEmpty()){
                    phone.setError("Please fill in the phone number");
                }
                else if(pw.isEmpty()){
                    password.setError("Please fill in the password");
                } else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //check if the phone numbers exists in the database
                            if(snapshot.hasChild(phoneNo)){
                                //user exists
                                 final String getPw = snapshot.child(phoneNo).child("pass").getValue(String.class);

                                 if(getPw.equals(pw)){
                                     Toast.makeText(LoginPhone.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                                     startActivity(new Intent(getApplicationContext(), OccupationTypes.class));
                                     finish();


                                 }else {
                                     Toast.makeText(LoginPhone.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                                 }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }

            }
        });
    }
}