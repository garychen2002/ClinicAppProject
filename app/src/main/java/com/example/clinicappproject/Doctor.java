package com.example.clinicappproject;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;

public class Doctor extends User implements Serializable {
    private String username;
    private String passwork;
    private String name;
    private String gender;
    private String specialization;
    private List<Patient> visted_patients;
    private List<Appointment> appointments;

    public Doctor() {

    }

    public Doctor(String user_n, String p, String n, String g, String sp, List<Patient> v_p, List<Appointment> appointment){
        super(user_n, p, n, g);
        this.specialization = sp;
        this.visted_patients = v_p;
        this.appointments = appointment;
    }

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }

    public void addPatient(Patient p){
        visted_patients.add(p);
    }

    public LinkedHashSet<Doctor> PastDoctor(Patient p){
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Patient> getVisted_patients() {
        return visted_patients;
    }

    public void setVisted_patients(List<Patient> visted_patients) {
        this.visted_patients = visted_patients;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}

