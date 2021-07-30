package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class DoctorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
    }

    public void openViewAppointment(){
//        Intent intent = new Intent(this, DisplayAppointmentActivity.class);
//        startActivity(intent);
    }

}
