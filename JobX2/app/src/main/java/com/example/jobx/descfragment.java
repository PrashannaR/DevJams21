package com.example.jobx;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class descfragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    String user,  occu,  year,  hour,  day,  ph,  aadh;
    Button btnPartTime, btnFullDay;

    public descfragment() {

    }

    public descfragment(String user, String occu, String year, String hour, String day, String ph, String aadh) {
        this.user = user;
        this.occu = occu;
        this.year = year;
        this.hour = hour;
        this.day = day;
        this.ph = ph;
        this.aadh = aadh;

    }


    public static descfragment newInstance(String param1, String param2) {
        descfragment fragment = new descfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_descfragment, container, false);


        TextView nametext = view.findViewById(R.id.nametext);
        TextView occupationtext = view.findViewById(R.id.occupationText);
        TextView years = view.findViewById(R.id.years);
        TextView partTime = view.findViewById(R.id.partTime);
        TextView fullTime = view.findViewById(R.id.fullTime);
        TextView aadhar = view.findViewById(R.id.aadhar);

        Button btnPartTime = (Button) view.findViewById(R.id.btnPartTime);
        Button btnFullDay = (Button) view.findViewById(R.id.btnFullDay);


        btnPartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), partTimeConfirm.class);
                intent.putExtra("user", user);
                intent.putExtra("occupation", occu);
                intent.putExtra("years", year);
                intent.putExtra("partTime", hour);
                intent.putExtra("fullTime", day);
                intent.putExtra("aadhar", aadh);
                startActivity(intent);
            }
        });

        btnFullDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), fullTimeConfirm.class);
                intent.putExtra("user", user);
                intent.putExtra("occupation", occu);
                intent.putExtra("years", year);
                intent.putExtra("partTime", hour);
                intent.putExtra("fullTime", day);
                intent.putExtra("aadhar", aadh);
                startActivity(intent);
            }
        });



        nametext.setText(user);
        occupationtext.setText(occu);
        years.setText(year);
        partTime.setText(hour);
        fullTime.setText(day);
        aadhar.setText(aadh);


        return view;


    }

    public void onBackPressed(){
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new recfragmentElectrician()).addToBackStack(null).commit();
    }
}