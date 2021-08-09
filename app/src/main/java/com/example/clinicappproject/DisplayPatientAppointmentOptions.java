package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DisplayPatientAppointmentOptions extends AppCompatActivity {

    public static final String Message = "DisplayType";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_patient_appointment_options);
    }

    public void prevPatientAppointments(View view){
        Intent intent = new Intent(this, DisplayAppointmentActivity.class);
        intent.putExtra(Message, "prevPatient");
        startActivity(intent);
    }

    public void upcomingPatientAppointments(View view){
        Intent intent = new Intent(this, DisplayAppointmentActivity.class);
        intent.putExtra(Message, "upcomingPatient");
        startActivity(intent);
    }

}