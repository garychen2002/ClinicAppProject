package com.example.clinicappproject;

import android.util.Log;

import java.util.ArrayList;

public class PatientCallback implements Callback {


    @Override
    public void doctorLogin(Doctor doctor) {

    }

    @Override
    public void patientLogin(Patient patient) {
        if (patient == null)
            Log.i("info", "invalid credentials");
        else
            Log.i("info", "successful for " + patient.getName());

    }

    @Override
    public void createAppointment(boolean success) {

    }

    @Override
    public void getDoctorAppointments(ArrayList<Appointment> list) {

    }

    @Override
    public void openChooseDoctor(ArrayList<Doctor> doctor_list) {

    }
}
