package com.example.clinicappproject;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class FirebaseAccess {


    static public void patientLogin(String username, String password, Callback callback)
    {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query userQuery = ref.child("patients").orderByChild("username").equalTo(username);
        userQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    Log.i("info", "SNAPSHOT EXISTS");
                    for (DataSnapshot user: snapshot.getChildren()) {
                        Log.i("info", user.getKey());
                        String compare = user.child("password").getValue().toString();
                        Log.i("info", compare);
                        if (compare.equals(password))
                        {
                            Log.i("info", "success");
                            Patient patient = user.getValue(Patient.class);
                            callback.patientLogin(patient);
                            // not sure how to get out of here
                        }
                        else
                        {
                            callback.patientLogin(null);
//                            Log.i("info", "invalid password");
                        }
                    }
                }
                else
                {
                    callback.patientLogin(null);
//                    Log.i("info", "invalid user");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("warning", "loadPost:onCancelled", error.toException());

            }
        });
    }

    static public void addAppointment(Appointment appointment)
    {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("appointments").push().setValue(appointment);
    }

    static public void addDoctor(Doctor doctor)
    {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference x = ref.child("patients").push();
        x.child("name").setValue(doctor.getName());
    }

    static public void addPatient(Patient patient)
    {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference x = ref.child("patients").push();
        x.child("name").setValue(patient.getName());
    }

    static public void filter(String gender, String specialization)
    {

    }

    static public void doctorLogin(String username, String password, Callback callback)
    {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query userQuery = ref.child("doctors").orderByChild("username").equalTo(username);
        userQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    Log.i("info", "SNAPSHOT EXISTS");
                    for (DataSnapshot user: snapshot.getChildren()) {
                        Log.i("info", user.getKey());
                        String compare = user.child("password").getValue().toString();
                        Log.i("info", compare);
                        if (compare.equals(password))
                        {
                            Log.i("info", "success");
                            Doctor doctor = user.getValue(Doctor.class);
                            callback.doctorLogin(doctor);
                            // not sure how to get out of here
                        }
                        else
                        {
                            callback.doctorLogin(null);
//                            Log.i("info", "invalid password");
                        }
                    }
                }
                else
                {
                    callback.doctorLogin(null);
//                    Log.i("info", "invalid user");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("warning", "loadPost:onCancelled", error.toException());

            }
        });
    }
}
