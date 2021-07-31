package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

public class BookAppointmentActivity extends AppCompatActivity {

    DatePicker picker;
    String gender;
    String spec;
    String time;
    Button find_doctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        find_doctor = (Button)findViewById(R.id.find_doctor);

    }


    public void gather_info(View view){
        Spinner sp1 = (Spinner)findViewById(R.id.department);
        spec= String.valueOf(sp1.getSelectedItem());

        Spinner sp2 = (Spinner)findViewById(R.id.doctor_gender);
        gender= String.valueOf(sp2.getSelectedItem());

        Spinner sp3 = (Spinner)findViewById(R.id.timePicker);
        time = String.valueOf(sp3.getSelectedItem());



    }

   // time= getString(R.id)


}