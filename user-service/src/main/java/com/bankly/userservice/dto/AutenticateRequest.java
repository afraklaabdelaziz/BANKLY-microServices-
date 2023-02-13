package com.bankly.userservice.dto;

import java.io.Serializable;

public class AutenticateRequest implements Serializable {

    private String email;
    private String password;

    public AutenticateRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AutenticateRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
