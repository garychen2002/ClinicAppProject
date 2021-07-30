package com.example.clinicappproject;

import java.util.List;

public class Doctor {
    private String name;
    private String gender;
    private String specialization;
    private List<Patient> visted_patients;
    private List<Patient> appointments;

    String getName() {
        return this.name;
    }

    String getGender() {
        return this.gender;
    }

    String getInfo() {
        return "Gender " + this.gender + "specialization: " + this.specialization;
    }


}