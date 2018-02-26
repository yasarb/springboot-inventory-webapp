package com.ysrbdlgn.spring.webapp.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class UserAddForm {

    @NotEmpty
    @Size(min = 3, max = 10)
    private String username;

    @NotEmpty
    @Size(min = 6, max = 10)
    private String password;

    @NotEmpty
    private String name;

    @NotEmpty
    private String lastName;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
