package com.example.clinicappproject;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;

public class Doctor extends User implements Serializable {

    private String specialization;
    private List<Patient> visited_patients;
    private List<Appointment> appointments;

    public Doctor() {

    }

    public Doctor(String user_n, String p, String n, String g, String sp, List<Patient> v_p, List<Appointment> appointment){
        super(user_n, p, n, g);
        this.specialization = sp;
        this.visited_patients = v_p;
        this.appointments = appointment;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void addPatient(Patient p){
        visited_patients.add(p);
    }

    public String PastDoctor(Patient p){
        return p.postDoctor();
    }

    public boolean filter(String gender, String specialization){
        if (gender.equals(this.gender) && specialization.equals(this.specialization)){
            return true;
        }else{
            return false;
        }
    }

    public String getInfo() {
        return "Gender " + this.gender + "specialization: " + this.specialization;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", specialization='" + specialization + '\'' +
                ", visited_patients=" + visited_patients +
                ", appointments=" + appointments +
                '}';
    }
}

