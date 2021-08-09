package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DisplayDoctorAppointmentOptions extends AppCompatActivity {

    public static final String Message = "DisplayType";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_appointment_options);
    }


    public void prevDoctorAppointments(View view){
        Intent intent = new Intent(this, DisplayAppointmentActivity.class);
        intent.putExtra(Message, "prevDoctor");
        startActivity(intent);
    }

    public void upcomingDoctorAppointments(View view){
        Intent intent = new Intent(this, DisplayAppointmentActivity.class);
        intent.putExtra(Message, "upcomingDoctor");
        startActivity(intent);
    }
}