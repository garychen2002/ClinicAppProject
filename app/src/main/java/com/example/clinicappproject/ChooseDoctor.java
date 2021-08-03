package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
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
    Doctor final_doctor;
    Patient current_patient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        current_patient = (Patient) intent.getSerializableExtra("com.example.clinicappproject.CurrentPatient");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_doctor);

        doctor_list = (Spinner)findViewById(R.id.spinner);
        apppointment_time = getIntent().getLongExtra("TIME",0);

        ArrayList<Doctor> doctors = (ArrayList<Doctor>) getIntent().getSerializableExtra("DOCTOR_LIST");

        ArrayList<String> doctor_names = new ArrayList<String>();
        for(Doctor d: doctors){
            doctor_names.add(d.getName());
        }


        doctorAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, doctor_names);

        doctor_list.setAdapter(doctorAdapter);

        choice = String.valueOf( doctor_list.getSelectedItem());

        for(Doctor d: doctors){
           if(d.getName().equals(choice)){
               final_doctor =d;
           }
        }
        current_patient.add_doctor(final_doctor);
        FirebaseAccess.addAppointment(new Appointment(final_doctor,current_patient,apppointment_time));

        final_book = (Button) findViewById(R.id.button2);
        final_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFinalPage();
            }
        });


    }



    public void openFinalPage(){
        Intent intent = new Intent(this, BookingFinalPage.class);
        startActivity(intent);
    }

}