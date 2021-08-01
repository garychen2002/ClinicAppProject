package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginTest extends AppCompatActivity implements Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_test);
    }

    public void loginButton(View view){
        Toast errorToast = Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT);
        errorToast.show();
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
            Toast errorToast = Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT);
            errorToast.show();
        }
        else {
            Intent intent = new Intent(this, PatientActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void createAppointment(boolean success) {

    }
}