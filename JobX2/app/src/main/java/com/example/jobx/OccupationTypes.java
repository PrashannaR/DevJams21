package com.example.jobx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class OccupationTypes extends AppCompatActivity {
    ImageView electrician, plumber, carpenter,
            cleaner, gardener, painter,
            labour, movers, blacksmith;

    TextView txtelectrician, txtplumber, txtcarpenter,
            txtcleaner, txtgardener, txtPainter,
            txtLaour, txtMovers, txtblacksmith;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_occupation_types);

        //Imageview hooks
        electrician = findViewById(R.id.electrician);
        plumber = findViewById(R.id.plumber);
        carpenter = findViewById(R.id.carpenter);
        cleaner = findViewById(R.id.cleaner);
        gardener = findViewById(R.id.gardener);
        painter = findViewById(R.id.painter);
        labour = findViewById(R.id.labour);
        movers = findViewById(R.id.movers);
        blacksmith = findViewById(R.id.blacksmith);

        //Textview hooks
        txtelectrician = findViewById(R.id.txtelectrician);
        txtplumber = findViewById(R.id.txtplumber);
        txtcarpenter = findViewById(R.id.txtcarpenter);
        txtcleaner = findViewById(R.id.txtcleaner);
        txtgardener = findViewById(R.id.txtgardener);
        txtPainter = findViewById(R.id.txtPainter);
        txtLaour = findViewById(R.id.txtLaour);
        txtMovers = findViewById(R.id.txtMovers);
        txtblacksmith = findViewById(R.id.txtblacksmith);

        //electrician
        electrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));
            }
        });

        txtelectrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));


            }
        });

        //plumber
        plumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));
            }
        });

        txtplumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));

            }
        });

        //carpenter
        carpenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));

            }
        });

        txtcarpenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));

            }
        });

        //cleaner
        cleaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));

            }
        });

        txtcleaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));

            }
        });

        //gardener
        gardener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));

            }
        });

        txtgardener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));

            }
        });


        //painter
        painter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));

            }
        });

        txtPainter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));

            }
        });

        //labour
        labour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));

            }
        });

        txtLaour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));

            }
        });

        //movers
        movers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));

            }
        });

        txtMovers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));

            }
        });


        //blacksmith
        blacksmith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));

            }
        });

        blacksmith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), electricianView.class));

            }
        });













    }
}