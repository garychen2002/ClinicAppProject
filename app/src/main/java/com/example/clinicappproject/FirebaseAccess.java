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
import java.util.GregorianCalendar;
import java.util.Date;

public class FirebaseAccess {


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


    static public void filter_time(Doctor doctor, ArrayList<Integer>timeList, GregorianCalendar date1, GregorianCalendar date2){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query doctorQuery = ref.child("appointments").orderByChild("doctor/username").equalTo(doctor.getUsername());
        doctorQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot data: snapshot.getChildren()){
                        Appointment a = data.getValue(Appointment.class);
                        if(a.getTime()<=date2.getTimeInMillis() && a.getTime()>= date1.getTimeInMillis()){
                            GregorianCalendar d =new GregorianCalendar();
                            d.setTimeInMillis(a.getTime());
                            timeList.remove(d.HOUR);
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



    static public void getScheduleByDoctor(Doctor doctor, Callback callback)
    {
        Log.i("info", "hhhhhhhhhhhhhhhh");

//        Log.i("info", type);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query userQuery = ref.child("appointments").orderByChild("doctor/username").equalTo(doctor.getUsername());
        ArrayList<Appointment> ScheduleArrayList = new ArrayList<Appointment>();
        userQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Log.i("info", "exists");
                    ScheduleArrayList.clear();
                    for (DataSnapshot user: snapshot.getChildren()) {
                        Appointment a = user.getValue(Appointment.class);
                        ScheduleArrayList.add(a);
                    }
                    Log.i("info", ScheduleArrayList.toString());
                    callback.getDoctorAppointments(ScheduleArrayList);
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

    static public void getAppointmentsByDoctor(Doctor doctor, Callback callback, String displayType)
    {
        Log.i("info", "hhhhhhhhhhhhhhhh");

        String type;
        type = displayType;


        Log.i("info", type);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query userQuery = ref.child("appointments").orderByChild("doctor/username").equalTo(doctor.getUsername());
        ArrayList<Appointment> prevAppointmentArrayList = new ArrayList<Appointment>();
        ArrayList<Appointment> upcomingAppointmentArrayList = new ArrayList<Appointment>();
        userQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    Log.i("info", "exists");
                    prevAppointmentArrayList.clear();
                    upcomingAppointmentArrayList.clear();
                    for (DataSnapshot user: snapshot.getChildren()) {
                        Appointment a = user.getValue(Appointment.class);
                        if (Long.compare(a.getTime(), System.currentTimeMillis()) < 0) {
                            prevAppointmentArrayList.add(a);
                        } else {
                            upcomingAppointmentArrayList.add(a);
                        }
                    }
                    Log.i("info", prevAppointmentArrayList.toString());
                    Log.i("info", upcomingAppointmentArrayList.toString());



                    if (type.equals("previous")) {
                        callback.getDoctorAppointments(prevAppointmentArrayList);
                        Log.i("info", "prevdoctcallback");
                    } else if (type.equals("upcoming")) {
                        callback.getDoctorAppointments(upcomingAppointmentArrayList);
                    }




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

}
