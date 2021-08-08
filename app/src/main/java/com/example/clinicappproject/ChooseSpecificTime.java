package com.example.clinicappproject;

import static android.Manifest.permission_group.CALENDAR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ChooseSpecificTime extends AppCompatActivity {

    Patient current_patient;
    Doctor final_doctor;
    GregorianCalendar date;
    Appointment appointment;
    Spinner timeList;
    ArrayAdapter<Integer> timeAdapter;
    ArrayList<Integer> time;
    Button Book;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_specific_time);

        Intent intent = getIntent();
        current_patient = UserSingleton.getInstance().getCurrentPatient();
        final_doctor = (Doctor) intent.getSerializableExtra("FINAL_DOCTOR");
        date = (GregorianCalendar) intent.getSerializableExtra("DATE");
        Book = (Button) findViewById(R.id.BOOK);
        timeList = (Spinner)findViewById(R.id.TimePicker);


        setAvailableTime();
        FirebaseAccess.filter_time(final_doctor,time,new GregorianCalendar(date.get(Calendar.YEAR),date.get(Calendar.MONTH), date.get(Calendar.HOUR),9,0),
                new GregorianCalendar(date.get(Calendar.YEAR),date.get(Calendar.MONTH), date.get(Calendar.HOUR),16,0));
        timeAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, time);

        timeList.setAdapter(timeAdapter);
        //GregorianCalendar ap_time = new GregorianCalendar(date.get(Calendar.YEAR),date.get(Calendar.MONTH), date.get(Calendar.HOUR),(Integer) timeList.getSelectedItem(),0);
       // appointment = new Appointment(final_doctor,current_patient,ap_time);
        //FirebaseAccess.addAppointment(appointment);


        Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFinalPage();
            }
        });








    }

    public void setAvailableTime(){
        time = new ArrayList<Integer>();
        int i=0;
        while(i!=8){
            if(i!=3){
                time.add(i+9);
            }
            i++;
        }
    }


    public void openFinalPage(){

        GregorianCalendar ap_time = new GregorianCalendar(date.get(Calendar.YEAR),date.get(Calendar.MONTH), date.get(Calendar.HOUR),(Integer) timeList.getSelectedItem(),0);
        appointment = new Appointment(final_doctor,current_patient,ap_time);
        FirebaseAccess.addAppointment(appointment);
        
        Intent intent = new Intent(this, BookingFinalPage.class);

        intent.putExtra("APPOINTMENT", appointment);
        startActivity(intent);
    }
}