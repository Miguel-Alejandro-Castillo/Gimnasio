package com.gym.bean;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Alejandro on 11/2/2018.
 */
public class LoginBean {

    @NotBlank(message = "login.username.empty")
    private String username;
    @NotBlank(message = "login.password.empty")
    private String password;

    public LoginBean() {
        super();
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
}
