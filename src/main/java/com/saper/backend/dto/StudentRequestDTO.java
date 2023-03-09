package com.saper.backend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class StudentRequestDTO implements Serializable {
    @NotNull(message = "Nome não pode ser nulo")
    @Size(message = "Nome deve ter tamanho mínimo 3 e máximo 10", min = 3, max = 10)
    String name;
    String login;
    @Size(message = "Password deve ter tamanho mínimo de 8 e máximo de 20", min = 8, max = 20)
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
