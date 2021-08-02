package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DoctorActivity extends AppCompatActivity {


    private Doctor currentDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        Intent intent = getIntent();
        currentDoctor = (Doctor) intent.getSerializableExtra("com.example.clinicappproject.CurrentDoctor");
        Log.i("info", currentDoctor.toString());
    }
    
    public void openUpcomingAppointment(View view){
        Intent intent = new Intent(this, DisplayAppointmentActivity.class);
        intent.putExtra("com.example.clinicappproject.CurrentDoctor", currentDoctor);
        startActivity(intent);
    }

}
