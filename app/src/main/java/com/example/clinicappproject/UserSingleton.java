package com.example.clinicappproject;

public class UserSingleton {

    private Patient currentPatient;
    private Doctor currentDoctor;
    private static UserSingleton currentUser;

    private UserSingleton() {

    }

    public Patient getCurrentPatient() {
        return currentPatient;
    }

    public Doctor getCurrentDoctor() {
        return currentDoctor;
    }

    public void setCurrentPatient(Patient p) {
        this.currentPatient = p;
    }

    public void setCurrentDoctor(Doctor currentDoctor) {
        this.currentDoctor = currentDoctor;
    }

    public static UserSingleton getInstance()
    {
        if (currentUser == null)
        {
            currentUser = new UserSingleton();
        }
        return currentUser;
    }


}
