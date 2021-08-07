package com.example.clinicappproject;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Model implements Contract.Model {


    @Override
    public void patientLogin(Contract.LoginListener callback, String username, String password) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query userQuery = ref.child("patients").orderByChild("username").equalTo(username);
        userQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Log.i("info", "SNAPSHOT EXISTS");
                    for (DataSnapshot user : snapshot.getChildren()) {
                        Log.i("info", user.getKey());
                        String compare = user.child("password").getValue().toString();
                        Log.i("info", compare);
                        if (compare.equals(password)) {
                            Log.i("info", "success");
                            Patient patient = user.getValue(Patient.class);
                            callback.onSuccess(patient);
                            // not sure how to get out of here
                        } else {
                            callback.onFailure();
//                            Log.i("info", "invalid password");
                        }
                    }
                } else {
                    callback.onFailure();
//                    Log.i("info", "invalid user");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("warning", "loadPost:onCancelled", error.toException());

            }
        });
    }

    @Override
    public void doctorLogin(Contract.LoginListener callback, String username, String password) {
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
                            callback.onSuccess(doctor);
                            // not sure how to get out of here
                        }
                        else
                        {
                            callback.onFailure();
//                            Log.i("info", "invalid password");
                        }
                    }
                }
                else
                {
                    callback.onFailure();
//                    Log.i("info", "invalid user");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("warning", "loadPost:onCancelled", error.toException());

            }
        });    }
}
