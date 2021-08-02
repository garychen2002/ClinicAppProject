package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;


import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.GregorianCalendar;




public class BookAppointmentActivity extends AppCompatActivity implements Callback {

    GregorianCalendar date;
    String gender;
    String spec;
    Button find_doctor;
    ArrayList<Doctor> doctors;
    View myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        find_doctor = (Button)findViewById(R.id.find_doctor);
        find_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myView = view;
                gather_info();


            }
        });

    }


    public void gather_info() {
        Spinner sp1 = (Spinner) findViewById(R.id.department);
        spec = String.valueOf(sp1.getSelectedItem());

        Spinner sp2 = (Spinner) findViewById(R.id.doctor_gender);
        gender = String.valueOf(sp2.getSelectedItem());

        Spinner sp3 = (Spinner) findViewById(R.id.timePicker);
        String time = String.valueOf(sp3.getSelectedItem());
        String[] parts = time.split(":");

        DatePicker dp = (DatePicker) findViewById(R.id.datePicker);
        date = new GregorianCalendar(dp.getYear(), dp.getMonth(), dp.getDayOfMonth(),
                Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));

        doctors = new ArrayList<Doctor>();
        FirebaseAccess.filter(gender, spec, doctors, this);


    }


    @Override
    public void doctorLogin(Doctor doctor) {

    }

    @Override
    public void patientLogin(Patient patient) {

    }

    @Override
    public void createAppointment(boolean success) {

    }

    @Override
    public void getDoctorAppointments(ArrayList<Appointment> list) {

    }

    @Override
    public void openChooseDoctor(ArrayList<Doctor> doctor_list) {
        doctors = doctor_list;
        Log.i("info", doctor_list.toString());
        if (doctors.isEmpty())
        {
            Snackbar error = Snackbar.make(myView, "No doctors found", Snackbar.LENGTH_SHORT);
            error.show();
        }
        else {
            Intent intent = new Intent(this, ChooseDoctor.class);
            intent.putExtra("DOCTOR_LIST", doctors);
            intent.putExtra("TIME", date.getTimeInMillis());
            startActivity(intent);
        }
    }
}