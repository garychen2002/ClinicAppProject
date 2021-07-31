package com.example.clinicappproject;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class FirebaseAccess {


    static public Patient patientLogin(String username, String password)
    {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Patient patient = null;
        Query userQuery = ref.child("patients").orderByChild("username").equalTo(username);
        userQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    for (DataSnapshot user: snapshot.getChildren()) {
                        if (user.child("password").equals(password))
                        {
                            Log.i("info", "success");
                            // not sure how to get out of here
                        }
                        else
                        {
                            Log.i("info", "invalid password");
                        }
                    }
                }
                else
                {
                    Log.i("info", "invalid user");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("warning", "loadPost:onCancelled", error.toException());

            }
        });
        return patient;
    }


}
