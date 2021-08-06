package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DisplayAppointmentOptions extends AppCompatActivity {

    public static final String Message = "DisplayType";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_appointment_options);
    }

    public void prevAppointments(View view){
        Intent intent = new Intent(this, DisplayAppointmentActivity.class);
        intent.putExtra(Message, "previous");
        startActivity(intent);
    }

    public void upcomingAppointments(View view){
        Intent intent = new Intent(this, DisplayAppointmentActivity.class);
        intent.putExtra(Message, "upcoming");
        startActivity(intent);
    }
}