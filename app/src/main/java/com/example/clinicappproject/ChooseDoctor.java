package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.Spinner;


import java.io.Serializable;
import java.util.ArrayList;

public class ChooseDoctor extends AppCompatActivity {
    Spinner doctor_list;
    ArrayAdapter<String> doctorAdapter;
    String choice;
    Button final_book;
    long apppointment_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_doctor);

        doctor_list = (Spinner)findViewById(R.id.spinner);
        apppointment_time = getIntent().getLongExtra("TIME",0);
//        ArrayList<Parcelable> doctors = getIntent().getParcelableArrayListExtra("DOCTOR_LIST");
        ArrayList<Doctor> doctors = (ArrayList<Doctor>) getIntent().getSerializableExtra("DOCTOR_LIST");

        ArrayList<String> doctor_names = new ArrayList<String>();
        for(Doctor d: doctors){
//            Doctor d = (Doctor)p;
            doctor_names.add(d.getName());
        }


        doctorAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, doctor_names);

        doctor_list.setAdapter(doctorAdapter);

        choice = String.valueOf( doctor_list.getSelectedItem());
        // create an appointment
        // show successful or failed in next activity

    }
}