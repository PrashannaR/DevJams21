package com.example.jobx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpDetails extends AppCompatActivity {
    Button btnDone;
    EditText name, address, phone, password;

    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_details);

        btnDone = findViewById(R.id.btnDone);
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);


        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                String user = name.getText().toString();
                String add = address.getText().toString();
                String ph = phone.getText().toString();
                String pass = password.getText().toString();
                
                Constructor constructor = new Constructor(user, add, ph, pass);
                reference.setValue(constructor);

                startActivity(new Intent(getApplicationContext(), OccupationTypes.class));
            }
        });
    }
}