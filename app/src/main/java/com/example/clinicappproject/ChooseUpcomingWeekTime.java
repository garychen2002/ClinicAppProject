package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ChooseUpcomingWeekTime extends AppCompatActivity {

    Doctor final_doctor;
    Patient current_patient;

    DatePicker dp;
    Button ShowTime;
    GregorianCalendar date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent= getIntent();
        current_patient = UserSingleton.getInstance().getCurrentPatient();
        final_doctor =(Doctor) intent.getSerializableExtra("FINAL_DOCTOR");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_upcoming_week_time);

        dp =(DatePicker) findViewById(R.id.DatePicker);
        upcomingWeek();

        ShowTime = (Button)findViewById(R.id.ShowTimePicker);

        date =new GregorianCalendar(dp.getYear(),dp.getMonth(), dp.getDayOfMonth());
        ShowTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openChooseSpecificTimePage();

            }

        });


    }



    public void upcomingWeek(){
        GregorianCalendar current = new GregorianCalendar();
        current.add(GregorianCalendar.DATE,1);
        dp.setMinDate(current.getTimeInMillis());
        current.add(GregorianCalendar.DATE,6);
        dp.setMaxDate(current.getTimeInMillis());

    }

    public void openChooseSpecificTimePage(){
        Intent intent = new Intent(this, ChooseSpecificTime.class);
        intent.putExtra("DATE", date);
        intent.putExtra("FINAL_DOCTOR", final_doctor);
        startActivity(intent);
    }
}