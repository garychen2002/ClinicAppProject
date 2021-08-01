package com.example.clinicappproject;

public interface Callback {
    void doctorLogin(Doctor doctor);
    void patientLogin(Patient patient);
    void createAppointment(boolean success);

}
