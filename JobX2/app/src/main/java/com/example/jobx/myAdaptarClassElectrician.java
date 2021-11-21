package com.example.jobx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myAdaptarClassElectrician extends FirebaseRecyclerAdapter<model, myAdaptarClassElectrician.myViewHolder> {


    public myAdaptarClassElectrician(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull model model) {
        holder.nametext.setText(model.getUser());
        holder.occupationtext.setText(model.getOccu());
        holder.years.setText(model.getYear());
        holder.partTime.setText(model.getHour());
        holder.fullTime.setText(model.getDay());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign, parent, false);
       return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        TextView nametext, occupationtext, years, yearsOf, partTime, fullTime;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            nametext = itemView.findViewById(R.id.nametext);
            occupationtext = itemView.findViewById(R.id.occupationText);
            years = itemView.findViewById(R.id.years);
            yearsOf = itemView.findViewById(R.id.yearsOf);
            partTime = itemView.findViewById(R.id.partTime);
            fullTime = itemView.findViewById(R.id.fullTime);

        }
    }
}
