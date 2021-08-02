package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.Spinner;


import java.util.ArrayList;

public class ChooseDoctor extends AppCompatActivity {
    Spinner doctor_list;
    ArrayAdapter<String> doctorAdapter;
    String choice;
    Button final_book;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_doctor);

        doctor_list = (Spinner)findViewById(R.id.spinner);

        ArrayList<String> doctors = getIntent().getStringArrayListExtra("DOCTOR_LIST");
        doctorAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, doctors);

        doctor_list.setAdapter(doctorAdapter);

        choice = String.valueOf( doctor_list.getSelectedItem());
        // create an appointment
        // show successful or failed in next activity

    }
}