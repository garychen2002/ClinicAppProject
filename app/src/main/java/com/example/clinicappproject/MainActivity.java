package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        FirebaseAccess database = new FirebaseAccess(ref);
        Patient est = database.patientLogin("test1", "test1");
        Patient est2 = database.patientLogin("test1", "test2");
        Patient est3 = database.patientLogin("test2", "test1");
    }


}