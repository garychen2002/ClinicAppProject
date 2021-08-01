package com.example.clinicappproject;

import java.util.List;

public abstract class User {
    private String username;
    private String password;
    protected String name;
    protected String gender;


    public User(){
    }

    public User(String user_n, String p, String n, String g){
        username = user_n;
        password = p;
        name = n;
        gender = g;
    }



    public abstract String getName();
    public abstract String getGender();


}
