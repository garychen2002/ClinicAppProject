package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        Intent intent = getIntent();
//        Doctor d = (Doctor)Intent.
    }
    
    public void openUpcomingAppointment(View view){
        Intent intent = new Intent(this, DisplayAppointmentActivity.class);
        startActivity(intent);
    }

}
