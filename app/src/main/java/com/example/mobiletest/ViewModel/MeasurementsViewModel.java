package com.example.mobiletest.ViewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.mobiletest.Measurements.Measurements;
import com.example.mobiletest.Repository.MeasurementsRepository;

import java.util.List;

public class MeasurementsViewModel extends AndroidViewModel {

    private final MeasurementsRepository measurementsRepository;

    public MeasurementsViewModel(@NonNull Application application) {
        super(application);

        measurementsRepository = new MeasurementsRepository();
    }

    public MutableLiveData<List<Measurements>> getMeasurements(Context context){
       return   measurementsRepository.getListOfMeasurements(context);
    }
}
