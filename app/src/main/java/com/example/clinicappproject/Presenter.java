package com.example.clinicappproject;

public class Presenter implements Contract.Presenter, Contract.LoginListener {

    Contract.Model model;
    Contract.LoginView view;

    public Presenter(Contract.Model model, Contract.LoginView view)
    {
        this.model = model;
        this.view = view;
    }
    @Override
    public void checkPatientCredentials() {
        String username = view.getUsername();
        String password = view.getPassword();
        model.patientLogin(this, username, password);
    }

    @Override
    public void checkDoctorCredentials() {
        String username = view.getUsername();
        String password = view.getPassword();
        model.doctorLogin(this, username, password);
    }

    //Callback functions
    @Override
    public void onSuccess(User user) {
        view.onLoginSuccess(user);
    }

    @Override
    public void onFailure() {
        view.onLoginFailure();
    }
}
