package com.example.clinicappproject;

import java.util.LinkedHashSet;
import java.util.List;

public class Doctor extends User{
    private String username;
    private String passwork;
    private String name;
    private String gender;
    private String specialization;
    private List<Patient> visted_patients;
    private List<Appointment> appointments;

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

}