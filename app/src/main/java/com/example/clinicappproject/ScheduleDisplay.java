package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class ScheduleDisplay extends AppCompatActivity implements Callback{
    Doctor currentDoctor;
    ArrayList<Appointment> appointments = new ArrayList<Appointment>();
    ArrayList<String> time = new ArrayList<String>();
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_display);
        TextView textView = findViewById(R.id.select_date);
        textView.setText(date);
        Intent intent = getIntent();
        currentDoctor = UserSingleton.getInstance().getCurrentDoctor();
        date = intent.getStringExtra(UpcomingSchedule.EXTRA_MESSAGE);

        FirebaseAccess.getScheduleByDoctor(currentDoctor, this);
    }

    @Override
    public void createAppointment(boolean success) {

    }

    @Override
    public void getDoctorAppointments(ArrayList<Appointment> list) {
        if (list != null) {
            appointments = list;
//            String start = date;
            String start = date + "/" + "10" + "/" + "00";

            for (Appointment a : appointments){
                time.add(a.getDate());
            }

            if (time.contains(date + "/" + "09" + "/" + "00")){
                TextView textView1 = findViewById(R.id.schedule9);
                textView1.setText("Booked");
            }else{
                TextView textView1 = findViewById(R.id.schedule9);
                textView1.setText("Not Booked");
            }

            if (time.contains(date + "/" + "10" + "/" + "00")){
                TextView textView1 = findViewById(R.id.schedule10);
                textView1.setText("Booked");
            }else{
                TextView textView1 = findViewById(R.id.schedule10);
                textView1.setText("Not Booked");
            }

            if (time.contains(date + "/" + "11" + "/" + "00")){
                TextView textView1 = findViewById(R.id.schedule11);
                textView1.setText("Booked");
            }else{
                TextView textView1 = findViewById(R.id.schedule11);
                textView1.setText("Not Booked");
            }

            if (time.contains(date + "/" + "12" + "/" + "00")){
                TextView textView1 = findViewById(R.id.schedule12);
                textView1.setText("Booked");
            }else{
                TextView textView1 = findViewById(R.id.schedule12);
                textView1.setText("Not Booked");
            }

            if (time.contains(date + "/" + "13" + "/" + "00")){
                TextView textView1 = findViewById(R.id.schedule13);
                textView1.setText("Booked");
            }else{
                TextView textView1 = findViewById(R.id.schedule13);
                textView1.setText("Not Booked");
            }

            if (time.contains(date + "/" + "14" + "/" + "00")){
                TextView textView1 = findViewById(R.id.schedule14);
                textView1.setText("Booked");
            }else{
                TextView textView1 = findViewById(R.id.schedule14);
                textView1.setText("Not Booked");
            }

            if (time.contains(date + "/" + "15" + "/" + "00")){
                TextView textView1 = findViewById(R.id.schedule15);
                textView1.setText("Booked");
            }else{
                TextView textView1 = findViewById(R.id.schedule15);
                textView1.setText("Not Booked");
            }

            if (time.contains(date + "/" + "16" + "/" + "00")){
                TextView textView1 = findViewById(R.id.schedule16);
                textView1.setText("Booked");
            }else{
                TextView textView1 = findViewById(R.id.schedule16);
                textView1.setText("Not Booked");
            }

        }
    }

    @Override
    public void openChooseDoctor(ArrayList<Doctor> doctor_list) {

    }
}