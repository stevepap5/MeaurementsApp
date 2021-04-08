package com.example.mobiletest.MeasurementsActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobiletest.Measurements.Measurements;
import com.example.mobiletest.R;

import java.util.List;

public class MeasurementsRecyclerViewAdapter extends RecyclerView.Adapter<MeasurementsRecyclerViewAdapter.ViewHolder> {

    List<Measurements> measurementsList;

    public MeasurementsRecyclerViewAdapter(List<Measurements> measurementsList) {
        this.measurementsList = measurementsList;
    }

    @NonNull
    @Override
    public MeasurementsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.measurements_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeasurementsRecyclerViewAdapter.ViewHolder holder, int position) {

        holder.meterIdTextView.setText(measurementsList.get(holder.getAdapterPosition()).getMeter_id());
        holder.latTextView.setText(String.valueOf(measurementsList.get(holder.getAdapterPosition()).getLat()));
        holder.lngTextView.setText(String.valueOf(measurementsList.get(holder.getAdapterPosition()).getLng()));
    }

    @Override
    public int getItemCount() {
        return measurementsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView meterIdTextView;
        private TextView latTextView;
        private TextView lngTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            meterIdTextView=itemView.findViewById(R.id.meterIdTextViewXml);
            latTextView=itemView.findViewById(R.id.latTextViewXml);
            lngTextView=itemView.findViewById(R.id.lngTextViewXml);
        }
    }
}
