package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class ScheduleDisplay extends AppCompatActivity implements Callback{
    Doctor currentDoctor;
    ArrayList<Appointment> appointments;
    ArrayList<String> time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_schedule_display);
        String date = intent.getStringExtra(UpcomingSchedule.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.select_date);
        textView.setText(date);
        currentDoctor = UserSingleton.getInstance().getCurrentDoctor();
        FirebaseAccess.getScheduleByDoctor(currentDoctor, this);

    }


    @Override
    public void createAppointment(boolean success) {

    }

    @Override
    public void getDoctorAppointments(ArrayList<Appointment> list) {
        if (list != null) {
            appointments = list;
            Log.i("info", appointments.toString());
        }
    }

    @Override
    public void openChooseDoctor(ArrayList<Doctor> doctor_list) {

    }
}