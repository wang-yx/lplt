package com.wyx.proj.request;

public class Login {
    private String userName;
    private String password;

    private String newPassword;

    private String newPassword_again;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword_again() {
        return newPassword_again;
    }

    public void setNewPassword_again(String newPassword_again) {
        this.newPassword_again = newPassword_again;
    }
}
