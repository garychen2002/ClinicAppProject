package com.example.clinicappproject;

import java.io.Serializable;
import java.util.LinkedHashSet;

public class Patient implements Serializable {

    private String name;
    private String gender;
    private LinkedHashSet<Doctor> prev_doctors;

    public Patient(){
    }

    public Patient(String name, String gender){
        this.name=name;
        this.gender=gender;
        prev_doctors=new LinkedHashSet<Doctor>();

    }

    public boolean add_doctor(Doctor d){
        return prev_doctors.add(d);
    }

    public LinkedHashSet<Doctor> postDoctor(){
        return prev_doctors;
    }

    @Override
    public boolean equals(Object obj){
        Patient p = (Patient)obj;
        return p.name.equals(this.name) && p.gender.equals(this.gender);
    }

    public String getName() {
        return name;
    }
}
