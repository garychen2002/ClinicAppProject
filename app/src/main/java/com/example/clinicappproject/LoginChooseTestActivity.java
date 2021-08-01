package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginChooseTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_choose_test);
    }


    public void patientLoginButton(View view){
        Intent intent = new Intent(this, PatientLoginTest.class);
        startActivity(intent);
    }
    public void doctorLoginButton(View view){
        Intent intent = new Intent(this, DoctorLoginTest.class);
        startActivity(intent);
    }
}