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
    Appointment appointment;
    Spinner timeList;
    ArrayAdapter<Integer> timeAdapter;
    ArrayList<Integer> time;

    Button ShowTime;
    Button BookApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent= getIntent();
        current_patient = UserSingleton.getInstance().getCurrentPatient();
        final_doctor =(Doctor) intent.getSerializableExtra("FINAL_DOCTOR");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_upcoming_week_time);

        DatePicker dp = findViewById(R.id.DatePicker);
        upcomingWeek(dp);
        timeList = (Spinner)findViewById(R.id.timePicker);
        BookApp= (Button)findViewById(R.id.BOOK);
        ShowTime = (Button)findViewById(R.id.ShowTime_button);


        ShowTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAvailableTime();
                FirebaseAccess.filter_time(final_doctor,time,new GregorianCalendar(dp.getYear(),dp.getMonth(), dp.getDayOfMonth(),9,0),
                        new GregorianCalendar(dp.getYear(),dp.getMonth(), dp.getDayOfMonth(),17,0));

                timeAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, time);

                timeList.setAdapter(timeAdapter);

                GregorianCalendar ap_time = new GregorianCalendar(dp.getYear(),dp.getMonth(),dp.getDayOfMonth(),(Integer) timeList.getSelectedItem(),0);
                appointment = new Appointment(final_doctor,current_patient,ap_time);
                FirebaseAccess.addAppointment(appointment);
            }

        });

        BookApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(appointment!=null){
                    openFinalPage();
                }

            }
        });






    }

    public void setAvailableTime(){
        time = new ArrayList<Integer>();
        for(int i =0; i<9; i++){
            if(i!=3) {
                time.add(i + 9);
            }
        }
    }


    public void upcomingWeek(DatePicker dp){
        GregorianCalendar current = new GregorianCalendar();
        current.add(GregorianCalendar.DATE,1);
        dp.setMinDate(current.getTimeInMillis());
        current.add(GregorianCalendar.DATE,6);
        dp.setMaxDate(current.getTimeInMillis());

    }

    public void openFinalPage(){
        Intent intent = new Intent(this, BookingFinalPage.class);
        intent.putExtra("APPOINTMENT", appointment);
        startActivity(intent);
    }
}