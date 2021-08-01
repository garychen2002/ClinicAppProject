package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class LoginTest extends AppCompatActivity implements Callback {

    private View myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_test);
    }

    public void loginButton(View view){
        myView = view;
//        Toast errorToast = Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG);
//        errorToast.show();
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
            intent.putex
            startActivity(intent);
        }
    }

    @Override
    public void createAppointment(boolean success) {

    }
}