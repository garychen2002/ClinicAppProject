package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class PatientActivity extends AppCompatActivity {


    private Button button1;
    private Button button2;
    //private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        button1 = (Button) findViewById(R.id.book);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBookAppointment();
            }
        });


        button2 = (Button) findViewById(R.id.profile);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyProfile();
            }
        });

        Patient est = FirebaseAccess.patientLogin("test1", "test1");
        Patient est2 = FirebaseAccess.patientLogin("test1", "test2");
        Patient est3 = FirebaseAccess.patientLogin("test2", "test1");

    };

    public void openBookAppointment(){
        Intent intent = new Intent(this, BookAppointmentActivity.class);
        startActivity(intent);
    }

    public void openMyProfile(){
        Intent intent = new Intent(this, MyProfileActivity.class);
        startActivity(intent);
    }


}
