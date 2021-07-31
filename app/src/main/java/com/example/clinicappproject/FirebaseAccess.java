package com.example.clinicappproject;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class FirebaseAccess {

    private DatabaseReference ref;
    public FirebaseAccess(DatabaseReference ref)
    {
        this.ref = ref;
    }

    public Patient patientLogin(String username, String password)
    {
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
                            // not sure how to get out of here
                        }
                    }
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
