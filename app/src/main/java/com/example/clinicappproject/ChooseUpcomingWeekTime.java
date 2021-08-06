package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ChooseUpcomingWeekTime extends AppCompatActivity {

    Doctor final_doctor;
    Patient current_patient;
    Appointment appointment;
    Spinner dateList;
    Spinner timeList;
    ArrayAdapter<String> dateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent= getIntent();
        current_patient = UserSingleton.getInstance().getCurrentPatient();
        final_doctor =(Doctor) intent.getSerializableExtra("FINAL_DOCTOR");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_upcoming_week_time);

        DatePicker dp = findViewById(R.id.DatePicker);
        upcomingWeek(dp);


    }





    public void upcomingWeek(DatePicker dp){
        GregorianCalendar current = new GregorianCalendar();
        current.add(GregorianCalendar.DATE,1);
        dp.setMinDate(current.getTimeInMillis());
        current.add(GregorianCalendar.DATE,6);
        dp.setMaxDate(current.getTimeInMillis());


    }
}