package com.todoapp.model;

public class User {

    private int userId;
    private String userFname;
    private String userLname;
    private String userGender;
    private String userContact;
    private String userEmail;
    private String userPassword;
    private int roleId;

    public User() {
    }

    public User(String userFname, String userLname, String userGender, String userContact, String userEmail,
            String userPassword, int roleId) {
        super();
        this.userFname = userFname;
        this.userLname = userLname;
        this.userGender = userGender;
        this.userContact = userContact;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFname() {
        return userFname;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userFname=" + userFname + ", userLname=" + userLname + ", userGender="
                + userGender + ", userContact=" + userContact + ", userEmail=" + userEmail + ", userPassword="
                + userPassword + ", roleId=" + roleId + "]";
    }
}