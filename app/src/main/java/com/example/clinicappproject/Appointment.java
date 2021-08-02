package com.example.clinicappproject;



import java.io.Serializable;
import java.time.LocalDateTime;
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

    @Override
    public String toString() {
        return "Appointment{" +
                "doctor=" + doctor +
                ", patient=" + patient +
                ", time=" + time +
                '}';
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
