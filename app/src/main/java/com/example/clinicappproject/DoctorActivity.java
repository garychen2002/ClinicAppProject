package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DoctorActivity extends AppCompatActivity {


    private Doctor currentDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        Intent intent = getIntent();
//        currentDoctor = (Doctor) intent.getSerializableExtra("com.example.clinicappproject.CurrentDoctor");
        currentDoctor = UserSingleton.getInstance().getCurrentDoctor();
        Log.i("info", currentDoctor.toString());

        TextView d_n = findViewById(R.id.Name);
        d_n.setText(currentDoctor.getName());

        TextView info = findViewById(R.id.d_info);
        info.setText(currentDoctor.getInfo());
    }
    
    public void openUpcomingAppointment(View view){
        Intent intent = new Intent(this, DisplayDoctorAppointmentOptions.class);
        intent.putExtra("com.example.clinicappproject.CurrentDoctor", currentDoctor);
        startActivity(intent);
    }

    public void openSchedule(View view){
        Intent intent = new Intent(this, UpcomingSchedule.class);
        intent.putExtra("com.example.clinicappproject.CurrentDoctor", currentDoctor);
        startActivity(intent);
    }

}
