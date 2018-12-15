package com.bank.welcometochase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long sid;

    private String firstName;
    private String lastName;
    private UserType userType;
    private UserStatus userStatus;

    public User() {
    }

    public User(String firstName, String lastName, UserType userType, UserStatus userStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
        this.userStatus = userStatus;
    }

    public Long getSid() {
        return sid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserStatus getUserStatus() { return userStatus; }

    public void setUserStatus(UserStatus userStatus) { this.userStatus = userStatus; }
}
