package com.example.clinicappproject;

import java.io.Serializable;
import java.util.LinkedHashSet;

public class Patient  extends User implements Serializable{


    private LinkedHashSet<Doctor> prev_doctors;

    public Patient(){
    }

    public Patient(String u, String p, String n, String g){
        super(u,p,n,g);

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

    @Override
    public String toString(){
        return name + " " + gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
