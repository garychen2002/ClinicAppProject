package com.example.clinicappproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Patient  extends User implements Serializable{


    private ArrayList<Doctor> prev_doctors;

    public Patient(){
    }

    public Patient(String u, String p, String n, String g){
        super(u,p,n,g);

        prev_doctors=new ArrayList<Doctor>();

    }

    public boolean add_doctor(Doctor d){
        return prev_doctors.add(d);
    }

    public String postDoctor(){
        String s = "";
        if (prev_doctors != null) {
            for (Doctor d : prev_doctors) {
                s = s + d.name + " ";
            }
        }
        else
        {
            return "No previous doctors";
        }
        return s;
    }

    @Override
    public boolean equals(Object obj){
        Patient p = (Patient)obj;
        return p.name.equals(this.name) && p.gender.equals(this.gender);
    }

    @Override
    public String toString(){
        return "Name: " + name + "\nGender: " + gender;
    }

    public ArrayList<Doctor> getPrev_doctors() {
        return prev_doctors;
    }

    public void setPrev_doctors(ArrayList<Doctor> prev_doctors) {
        this.prev_doctors = prev_doctors;
    }
}
