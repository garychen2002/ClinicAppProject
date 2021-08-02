package com.example.clinicappproject;



import java.io.Serializable;
import java.util.GregorianCalendar;

public class Appointment implements Serializable {

    private Doctor doctor;
    private Patient patient;
    private GregorianCalendar start;

    public Appointment(){

    }

    public Appointment(Doctor d, Patient p, GregorianCalendar time){
        doctor = d;
        patient = p;
        start = time;

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

    public GregorianCalendar getStart() {
        return start;
    }

    public void setStart(GregorianCalendar start) {
        this.start = start;
    }
}
