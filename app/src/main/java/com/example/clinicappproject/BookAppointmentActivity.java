package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;



import java.util.GregorianCalendar;




public class BookAppointmentActivity extends AppCompatActivity {

    GregorianCalendar date;
    String gender;
    String spec;
    Button find_doctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        find_doctor = (Button)findViewById(R.id.find_doctor);
        find_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //gather_info();

            }
        });

    }


    public void gather_info(View view){
        Spinner sp1 = (Spinner)findViewById(R.id.department);
        spec= String.valueOf(sp1.getSelectedItem());

        Spinner sp2 = (Spinner)findViewById(R.id.doctor_gender);
        gender= String.valueOf(sp2.getSelectedItem());

        Spinner sp3 = (Spinner)findViewById(R.id.timePicker);
        String time = String.valueOf(sp3.getSelectedItem());
        String [] parts = time.split(":");

        DatePicker dp = (DatePicker)findViewById(R.id.datePicker);
        date= new GregorianCalendar(dp.getYear(), dp.getMonth(), dp.getDayOfMonth(),
                Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));

    }

    public void openChooseDDoctor(){
        Intent intent = new Intent(this, ChooseDoctor.class);
        startActivity(intent);
    }




}