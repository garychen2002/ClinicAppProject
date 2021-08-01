package com.example.clinicappproject;

import android.util.Log;

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
}
