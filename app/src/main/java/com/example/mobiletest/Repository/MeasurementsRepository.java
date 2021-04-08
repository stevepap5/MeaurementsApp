package com.example.mobiletest.Repository;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.MutableLiveData;

import com.example.mobiletest.Api.MeasurementsApi;
import com.example.mobiletest.Measurements.Measurements;
import com.example.mobiletest.Retrofit.MeasurementRetrofitService;
import com.example.mobiletest.Retrofit.UserLoginRetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class MeasurementsRepository {

    private static MeasurementsApi measurementsApi;
    private final MutableLiveData<List<Measurements>> listOfMeasurements = new MutableLiveData<>();

    public MeasurementsRepository() {

        measurementsApi= MeasurementRetrofitService.getInterface();
    }

    public MutableLiveData<List<Measurements>> getListOfMeasurements(Context context){

        SharedPreferences prefs = context.getSharedPreferences("tokens", MODE_PRIVATE);
        if (prefs!=null) {

            Call<List<Measurements>> callList = measurementsApi.getMeasurements("Bearer " +
                    prefs.getString("accessToken", null));
            callList.enqueue(new Callback<List<Measurements>>() {
                @Override
                public void onResponse(Call<List<Measurements>> call, Response<List<Measurements>> response) {
                    listOfMeasurements.setValue(response.body());
                }

                @Override
                public void onFailure(Call<List<Measurements>> call, Throwable t) {

                }
            });
        }
        return listOfMeasurements;
    }
}
