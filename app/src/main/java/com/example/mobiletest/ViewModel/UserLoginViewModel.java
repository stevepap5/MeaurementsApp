package com.example.mobiletest.ViewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.mobiletest.Repository.UserLoginRepository;

import java.util.HashMap;

public class UserLoginViewModel extends AndroidViewModel {

    private final UserLoginRepository userLoginRepository;

    public UserLoginViewModel(@NonNull Application application) {
        super(application);

        userLoginRepository=new UserLoginRepository();
    }

    public void setUserLogin(HashMap<String,Object> emailAndPassword,Context context){
        userLoginRepository.getUserAccessToken(emailAndPassword,context);
    };


}
