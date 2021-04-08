package com.example.mobiletest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mobiletest.MeasurementsActivity.MeasurementsActivity;
import com.example.mobiletest.ViewModel.UserLoginViewModel;
import com.google.android.material.button.MaterialButton;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText emailUserEditText;
    private EditText passwordUserEditText;
    private MaterialButton loginUserMaterialButton;
    private UserLoginViewModel userLoginViewModel;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFindViewsById();
        setLoginUserViewModel();

    }

    private void setFindViewsById(){

        emailUserEditText=findViewById(R.id.emailUserEditTextXml);
        passwordUserEditText=findViewById(R.id.passwordUserEditTextXml);
        loginUserMaterialButton=findViewById(R.id.loginUserMaterialButtonXml);
    }

    private void setLoginUserViewModel(){

        userLoginViewModel=new ViewModelProvider(this).get(UserLoginViewModel.class);
        loginUserMaterialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,Object> emailAndPassword=new HashMap<>();
                emailAndPassword.put("email",emailUserEditText.getText().toString());
                emailAndPassword.put("password",passwordUserEditText.getText().toString());
                context=MainActivity.this;

                userLoginViewModel.setUserLogin(emailAndPassword,context);

                Intent intent=new Intent(MainActivity.this, MeasurementsActivity.class);
                startActivity(intent);
            }
        });

    }
}