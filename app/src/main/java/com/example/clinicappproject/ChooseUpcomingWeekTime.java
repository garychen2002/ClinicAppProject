package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ChooseUpcomingWeekTime extends AppCompatActivity {

    Doctor final_doctor;
    Patient current_patient;
    Appointment appointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_upcoming_week_time);

    }
}