package com.example.clinicappproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class BookingFinalPage extends AppCompatActivity {
    Appointment appointment;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_final_page);


        Intent intent = getIntent();
        appointment = (Appointment) intent.getSerializableExtra("APPOINTMENT");
        TextView tv = (TextView) findViewById(R.id.final_message);
        tv.setText(appointment.toString());
    }
}