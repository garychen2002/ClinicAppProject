package com.example.clinicappproject;

import java.io.Serializable;
import java.util.List;

public abstract class User implements Serializable {
    protected String username;
    protected String password;
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


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
