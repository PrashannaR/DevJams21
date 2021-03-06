package com.example.jobxregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class workDetails extends AppCompatActivity {

    EditText Occupation, perHour, perDay, yearsOfExp;
    Button btnAddUser;

    FirebaseDatabase rootNode;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_details);

        Occupation = findViewById(R.id.Occupation);
        perHour = findViewById(R.id.perHour);
        perDay = findViewById(R.id.perDay);
        btnAddUser = findViewById(R.id.btnAddUser);
        yearsOfExp = findViewById(R.id.yearsOfExp);

        //get values from the details page
        Intent intent = getIntent();
        String user = intent.getStringExtra("User");
        String add = intent.getStringExtra("Address");
        String ph = intent.getStringExtra("phone");
        String aadh = intent.getStringExtra("aadhar");
       // String photo = intent.getStringExtra("photo");

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //database setup
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("employees");

                String occu = Occupation.getText().toString();
                String hour = perHour.getText().toString();
                String day = perDay.getText().toString();
                String year = yearsOfExp.getText().toString();

                //upload data
                Constructor Constructor = new Constructor(user, add, ph, aadh,
                        occu, hour, day, year);
                reference.child(ph).setValue(Constructor);

                Occupation.getText().clear();
                perHour.getText().clear();
                perDay.getText().clear();

                startActivity(new Intent(getApplicationContext(), addUser.class ));




            }
        });



    }
}