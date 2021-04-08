package com.example.mobiletest.Api;

import com.example.mobiletest.Token.Token;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserLoginApi {

    @POST("auth/token/")
    Call<Token> getUserAccessToken(@Body HashMap<String,Object> emailAndPassword);

}
