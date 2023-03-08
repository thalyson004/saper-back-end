package com.saper.backend.dto;

import com.saper.backend.model.User;

public class UserRequestDTO {
    String name;
    String login;
    String password;
    String repeated_password;

    public UserRequestDTO(String name, String login, String password, String repeated_password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.repeated_password = repeated_password;
    }

    public UserRequestDTO(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public UserRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeated_password() {
        return repeated_password;
    }

    public void setRepeated_password(String repeated_password) {
        this.repeated_password = repeated_password;
    }

    public User toClient() {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setLogin(login);
        return user;
    }
}
