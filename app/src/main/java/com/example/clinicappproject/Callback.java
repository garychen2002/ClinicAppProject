package com.example.clinicappproject;

import java.util.ArrayList;

public interface Callback {
    void doctorLogin(Doctor doctor);
    void patientLogin(Patient patient);
    void createAppointment(boolean success);
    void getDoctorAppointments(ArrayList<Appointment> list);

}
