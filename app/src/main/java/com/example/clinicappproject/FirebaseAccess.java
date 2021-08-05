package com.example.clinicappproject;

import android.telecom.Call;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

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


    static public void filter_time(ArrayList<Doctor> doctor_list, long time){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query timeQuery = ref.child("appointments").orderByChild("time").equalTo(time);
        timeQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(!doctor_list.isEmpty()&&snapshot.exists()){
                    for(DataSnapshot data: snapshot.getChildren()){
                        Appointment a = data.getValue(Appointment.class);
                        if(doctor_list.contains(a.getDoctor())){
                            doctor_list.remove(a.getDoctor());
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("warning", "loadPost:onCancelled", error.toException());
            }
        });
    }


    static public void filter(String gender, String specialization, ArrayList<Doctor> doctor_list, Callback callback)
    {
        doctor_list.clear();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        Query doctorQuery = ref.child("doctors").orderByChild("specialization").equalTo(specialization);
        doctorQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot data: snapshot.getChildren()){
                    Doctor d = data.getValue(Doctor.class);
                    if (d.getGender().equals(gender)) {
                        doctor_list.add(d);
                    }

                }
                //FirebaseAccess.filter_time(doctor_list, time);
                callback.openChooseDoctor(doctor_list);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("warning", "loadPost:onCancelled", error.toException());
            }
        });





    }



    static public void getAppointmentsByDoctor(Doctor doctor, Callback callback)
    {
        Log.i("info", "hhhhhhhhhhhhhhhh");

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query userQuery = ref.child("appointments").orderByChild("doctor/username").equalTo(doctor.getUsername());
        ArrayList<Appointment> appointmentArrayList = new ArrayList<Appointment>();
        userQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Log.i("info", "exists");
                    appointmentArrayList.clear();
                    for (DataSnapshot user: snapshot.getChildren()) {
                        Appointment a = user.getValue(Appointment.class);
                        appointmentArrayList.add(a);
                    }
                    Log.i("info", appointmentArrayList.toString());
                    callback.getDoctorAppointments(appointmentArrayList);

                }
                else
                    Log.i("info", "doesnt exists");


            }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.w("warning", "loadPost:onCancelled", error.toException());

                }
            });


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
