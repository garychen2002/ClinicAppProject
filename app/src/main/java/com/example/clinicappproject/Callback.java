package com.example.clinicappproject;

import java.util.ArrayList;

public interface Callback {
    void createAppointment(boolean success);
    void getDoctorAppointments(ArrayList<Appointment> list);
    void openChooseDoctor(ArrayList<Doctor> doctor_list);

}
