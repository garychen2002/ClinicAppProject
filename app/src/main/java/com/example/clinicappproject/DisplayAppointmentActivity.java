package com.example.clinicappproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class DisplayAppointmentActivity extends AppCompatActivity implements Callback {
    ArrayList<Appointment> appointments;
    Doctor currentDoctor;
    DoctorAppAdapter dAdapter;
    RecyclerView recyclerView;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_appointment);
        Log.i("info", "help");
        Intent intent = getIntent();
        currentDoctor = (Doctor) intent.getSerializableExtra("com.example.clinicappproject.CurrentDoctor");
               Log.i("info", "help2");
//        Patient p = new Patient("test3", "password3", "tester", "Male");
//        GregorianCalendar g = new GregorianCalendar();
//        Appointment a = new Appointment(currentDoctor, p, g);
//        FirebaseAccess.addAppointment(a);
        FirebaseAccess.getAppointmentsByDoctor(currentDoctor, this);

        dAdapter = new DoctorAppAdapter(DisplayAppointmentActivity.this,appointments);
        recyclerView.setAdapter(dAdapter);


        ChangeListener();
    }

    public void ChangeListener(){
    //  need implementation still
    }


    @Override
    public void doctorLogin(Doctor doctor) {

    }

    @Override
    public void patientLogin(Patient patient) {

    }

    @Override
    public void createAppointment(boolean success) {

    }

    @Override
    public void getDoctorAppointments(ArrayList<Appointment> list) {
        appointments = list;
        Log.i("info", appointments.toString());
    }

    @Override
    public void openChooseDoctor(ArrayList<Doctor> doctor_list) {

    }
}