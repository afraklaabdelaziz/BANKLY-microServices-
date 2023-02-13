package com.bankly.userservice.dto;

import java.io.Serializable;

public class UserAppDto implements Serializable {
    private String lastName;
    private String firstName;
    private String cin;

    private String email;

    private String phone;

    private String password;

    public UserAppDto(String lastName, String firstName, String cin, String email, String phone, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.cin = cin;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public UserAppDto() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserAppDto{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", cin='" + cin + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
