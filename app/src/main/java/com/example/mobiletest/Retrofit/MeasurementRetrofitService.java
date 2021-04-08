package com.example.mobiletest.Retrofit;

import com.example.mobiletest.Api.MeasurementsApi;
import com.example.mobiletest.Api.UserLoginApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MeasurementRetrofitService {

    private static final String BASE_URL = "https://test-api.gwf.ch/";
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static MeasurementsApi getInterface() {
        return retrofit.create(MeasurementsApi.class);
    }
}
