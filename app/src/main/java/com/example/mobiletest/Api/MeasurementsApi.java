package com.example.mobiletest.Api;

import com.example.mobiletest.Measurements.Measurements;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface MeasurementsApi {

    @GET("reports/measurements/")
    Call<List<Measurements>> getMeasurements(@Header("Authorization") String authHeader);
}
