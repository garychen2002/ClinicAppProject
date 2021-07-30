package com.example.clinicappproject;

import java.util.List;

public class Doctor extends User{
    private String username;
    private String passwork;
    private String name;
    private String gender;
    private String specialization;
    private List<Patient> visted_patients;
    private List<Patient> appointments;

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }

    public String getInfo() {
        return "Gender " + this.gender + "specialization: " + this.specialization;
    }

}