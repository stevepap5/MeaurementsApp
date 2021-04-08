package com.example.mobiletest.MeasurementsActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mobiletest.Measurements.Measurements;
import com.example.mobiletest.R;
import com.example.mobiletest.ViewModel.MeasurementsViewModel;
import com.example.mobiletest.ViewModel.UserLoginViewModel;

import java.util.ArrayList;
import java.util.List;

public class MeasurementsActivity extends AppCompatActivity {

    private RecyclerView measurementsRecyclerView;
    private MeasurementsRecyclerViewAdapter measurementsRecyclerViewAdapter;
    private List<Measurements> measurementsList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurements);

        measurementsRecyclerView=findViewById(R.id.measurementRecyclerViewXml);
        measurementsRecyclerView.setHasFixedSize(true);
        measurementsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        MeasurementsViewModel measurementsViewModel=new ViewModelProvider(this).get(MeasurementsViewModel.class);
        measurementsViewModel.getMeasurements(MeasurementsActivity.this).observe(this, new Observer<List<Measurements>>() {
            @Override
            public void onChanged(List<Measurements> measurements) {
                if(measurements!=null){
                    measurementsList.addAll(measurements);
                    measurementsRecyclerViewAdapter.notifyDataSetChanged();
                }
            }
        });
        measurementsRecyclerViewAdapter=new MeasurementsRecyclerViewAdapter(measurementsList);
        measurementsRecyclerView.setAdapter(measurementsRecyclerViewAdapter);
    }
}