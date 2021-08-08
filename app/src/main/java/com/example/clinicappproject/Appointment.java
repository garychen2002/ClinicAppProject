package com.example.clinicappproject;



import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.GregorianCalendar;

public class Appointment implements Serializable {

    private Doctor doctor;
    private Patient patient;
    private long time;

    public Appointment(){

    }

    public Appointment(Doctor d, Patient p, long time){
        doctor = d;
        patient = p;
        this.time = time;

    }

    public Appointment(Doctor d, Patient p, GregorianCalendar time){
        doctor = d;
        patient = p;
        this.time = time.getTimeInMillis();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public String toString() {
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String formattedTime = format.format(date);
        return "Appointment{" +
                "doctor = " + doctor.getName() +
                ", patient=" + patient.getName() +
                ", time=" + formattedTime +
                '}';
    }

    public String booking_status(){
        if (patient != null){
            return "Booked";
        }else{
            return "Not Booked";
        }
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public long getTime() {
        return time;
    }

    public String getDateAndTime() {
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd/hh/mm");
        String formattedTime = format.format(date);
        return formattedTime;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getPatientInfo(){
        return patient.toString();
    }

    public String getPreDoctor(){
        return patient.postDoctor();
    }
}
