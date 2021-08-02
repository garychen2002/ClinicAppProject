package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DisplayAppointmentActivity extends AppCompatActivity implements Callback {
    ArrayList<Appointment> appointments;
    Doctor currentDoctor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_appointment);
        Intent intent = getIntent();
        currentDoctor = (Doctor) intent.getSerializableExtra("com.example.clinicappproject.CurrentDoctor");
//        Patient p = new Patient("test3", "password3", "tester", "Male");
//        GregorianCalendar g = new GregorianCalendar();
//        Appointment a = new Appointment(currentDoctor, p, g);
//        FirebaseAccess.addAppointment(a);
        FirebaseAccess.getAppointmentsByDoctor(currentDoctor, this);

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
}