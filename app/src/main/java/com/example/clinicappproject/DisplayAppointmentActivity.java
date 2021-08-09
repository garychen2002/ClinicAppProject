package com.example.clinicappproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class DisplayAppointmentActivity extends AppCompatActivity implements Callback {
    ArrayList<Appointment> appointments = new ArrayList<Appointment>();
    Doctor currentDoctor;
    Patient currentPatient;
    DoctorAppAdapter dAdapter;
    RecyclerView recyclerView;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_appointment);
        Log.i("info", "help");
        recyclerView = findViewById(R.id.rvAppointments);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();
        String displayType = intent.getStringExtra(DisplayDoctorAppointmentOptions.Message);

        if (displayType.equals("prevPatient") || displayType.equals("upcomingPatient")){
            currentPatient = UserSingleton.getInstance().getCurrentPatient();
            FirebaseAccess.getAppointmentsByPatient(currentPatient, this, displayType);
        }

        if (displayType.equals("prevDoctor") || displayType.equals("upcomingDoctor")){
            currentDoctor = UserSingleton.getInstance().getCurrentDoctor();
            FirebaseAccess.getAppointmentsByDoctor(currentDoctor, this, displayType);
        }
//        currentDoctor = (Doctor) intent.getSerializableExtra("com.example.clinicappproject.CurrentDoctor");
               Log.i("info", "help2");
//        Patient p = new Patient("test3", "password3", "tester", "Male");
//        GregorianCalendar g = new GregorianCalendar();
//        Appointment a = new Appointment(currentDoctor, p, g);
//        FirebaseAccess.addAppointment(a);

//        ChangeListener();
    }

//    public void ChangeListener(){
//    //  need implementation still
//    }

    @Override
    public void createAppointment(boolean success) {

    }

    @Override
    public void getDoctorAppointments(ArrayList<Appointment> list) {
        if (list != null) {
            appointments = list;
            Log.i("info", appointments.toString());
            dAdapter = new DoctorAppAdapter(DisplayAppointmentActivity.this, appointments);
            recyclerView.setAdapter(dAdapter);
        }
    }

    @Override
    public void openChooseDoctor(ArrayList<Doctor> doctor_list) {

    }
}