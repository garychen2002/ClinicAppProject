package com.example.clinicappproject;

import android.app.Activity;

public interface Contract {

    public interface Model {
        public void patientLogin(LoginListener callback, String username, String password);
        public void doctorLogin(LoginListener callback, String username, String password);

    }

    public interface LoginView {

        public String getUsername();
        public String getPassword();
        public void onLoginSuccess(User user);
        public void onLoginFailure();

    }

    public interface Presenter {
        public void checkPatientCredentials();
        public void checkDoctorCredentials();

    }

    public interface LoginListener {

        public void onSuccess(User user); // callback to view's onloginsuccess
        public void onFailure();
    }
}
