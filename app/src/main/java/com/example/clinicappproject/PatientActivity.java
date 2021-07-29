package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class PatientActivity extends AppCompatActivity {


    private Button button1;

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

    };


    public void openBookAppointment(){
        Intent intent = new Intent(this, BookAppointmentActivity.class);
        startActivity(intent);
    }
}
