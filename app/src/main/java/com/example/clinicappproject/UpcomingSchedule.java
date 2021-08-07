package com.example.clinicappproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import java.util.ArrayList;

public class UpcomingSchedule extends AppCompatActivity{
    ArrayList<Appointment> appointments;
    Doctor currentDoctor;
    private CalendarView calendarView;
    public static final String EXTRA_MESSAGE = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_schedule);

        Intent intent = getIntent();
        currentDoctor = UserSingleton.getInstance().getCurrentDoctor();
        calendarView = (CalendarView) findViewById(R.id.calendarView);
//        FirebaseAccess.getScheduleByDoctor(currentDoctor, this);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = year + "/" + (month+1) + "/" + dayOfMonth;
                Intent intent1 = new Intent(UpcomingSchedule.this, ScheduleDisplay.class);
                intent1.putExtra(EXTRA_MESSAGE, date);
                intent1.putExtra("com.example.clinicappproject.CurrentDoctor", currentDoctor);
                startActivity(intent1);
            }

        });
    }

}