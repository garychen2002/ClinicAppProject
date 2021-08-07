package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class PatientLoginTest extends AppCompatActivity implements Callback, Contract.LoginView {

    private View myView;
    private Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login_test);
        presenter = new Presenter(new Model(), this);

//        Doctor a = new Doctor("username1", "password1", "est", "Male", "Brains", new ArrayList<Patient>(), new ArrayList<Appointment>());
//        FirebaseAccess.addDoctor(a);
    }

    public void loginButton(View view){
        myView = view;
//        String username = getUsername();
//        String password = getPassword();
//        FirebaseAccess.patientLogin(username, password, this);
        presenter.checkPatientCredentials();
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

    @Override
    public String getUsername() {
        EditText usernameText = (EditText) findViewById(R.id.editTextTextUsername);
        String username = usernameText.getText().toString();
        return username;    }

    @Override
    public String getPassword() {
        EditText passwordText = (EditText) findViewById(R.id.editTextTextPassword);
        String password = passwordText.getText().toString();
        return password;    }

    @Override
    public void onLoginSuccess(User user) {
        Patient patient = (Patient) user;
        Intent intent = new Intent(this, PatientActivity.class);
        Log.i("info", patient.toString());
        UserSingleton.getInstance().setCurrentPatient(patient);
        intent.putExtra("com.example.clinicappproject.CurrentPatient", patient);
        startActivity(intent);
    }

    @Override
    public void onLoginFailure() {
        Snackbar ackbar = Snackbar.make(myView, "wrong credentials", Snackbar.LENGTH_SHORT);
        ackbar.show();
    }


}