package com.example.clinicappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class PatientActivity extends AppCompatActivity {


    private Button button1;
    private Button button2;
    private Button button3;
    private Patient currentPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        currentPatient = UserSingleton.getInstance().getCurrentPatient();
//        currentPatient = (Patient) intent.getSerializableExtra("com.example.clinicappproject.CurrentPatient");
        Log.i("info", currentPatient.toString());
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


        button3 = (Button)findViewById(R.id.appointment);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyAppointment();
            }
        });
//        PatientCallback callback = new PatientCallback();
//        Patient est = FirebaseAccess.patientLogin("test1", "password1", callback);
//        Patient est2 = FirebaseAccess.patientLogin("test2", "password2", callback);
//        Patient est3 = FirebaseAccess.patientLogin("test2", "test1", callback);

    };

    public void openBookAppointment(){
        Intent intent = new Intent(this, BookAppointmentActivity.class);
        intent.putExtra("com.example.clinicappproject.CurrentPatient", currentPatient);
        startActivity(intent);
    }

    public void openMyProfile(){
        Intent intent = new Intent(this, MyProfileActivity.class);
        startActivity(intent);
    }

    public void openMyAppointment(){
        Intent intent =new Intent(this, DisplayPatientAppointmentOptions.class);
        intent.putExtra("com.example.clinicappproject.CurrentPatient", currentPatient);
        startActivity(intent);
    }


}
