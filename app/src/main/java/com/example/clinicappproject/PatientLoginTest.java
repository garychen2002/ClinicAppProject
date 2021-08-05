package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class PatientLoginTest extends AppCompatActivity implements Callback {

    private View myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login_test);

//        Doctor a = new Doctor("username1", "password1", "est", "Male", "Brains", new ArrayList<Patient>(), new ArrayList<Appointment>());
//        FirebaseAccess.addDoctor(a);
    }

    public void loginButton(View view){
        myView = view;
        EditText usernameText = (EditText) findViewById(R.id.editTextTextUsername);
        EditText passwordText = (EditText) findViewById(R.id.editTextTextPassword);
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();
        FirebaseAccess.patientLogin(username, password, this);
    }

    @Override
    public void doctorLogin(Doctor doctor) {

    }

    @Override
    public void patientLogin(Patient patient) {
        if (patient == null)
        {
            Snackbar ackbar = Snackbar.make(myView, "wrong credentials", Snackbar.LENGTH_SHORT);
            ackbar.show();
        }
        else {
            Intent intent = new Intent(this, PatientActivity.class);
            Log.i("info", patient.toString());
            UserSingleton.getInstance().setCurrentPatient(patient);
            intent.putExtra("com.example.clinicappproject.CurrentPatient", patient);
            startActivity(intent);
        }
    }

    @Override
    public void createAppointment(boolean success) {

    }

    @Override
    public void getDoctorAppointments(ArrayList<Appointment> list) {

    }

    @Override
    public void openChooseDoctor(ArrayList<Doctor> doctor_list) {

    }
}