package com.example.clinicappproject;

import java.util.List;

public abstract class User {
    private String username;
    private String password;
    private String name;
    private String gender;

    public User(String user_n, String p, String n, String g){
        username = user_n;
        password = p;
        name = n;
        gender = g;
    }

    public abstract String getName();
    public abstract String getGender();

}
