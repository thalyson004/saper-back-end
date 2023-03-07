package com.saper.backend.dto;

public class StudentRequestDTO {

    String name;
    String login;
    String password;
    String repeated_password;

    public StudentRequestDTO(String name, String login, String password, String repeated_password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.repeated_password = repeated_password;
    }

    public StudentRequestDTO() {
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
}
