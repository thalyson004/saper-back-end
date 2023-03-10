package com.saper.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class StudentRequestDTO implements Serializable {

    @Size(min = 3, max = 10, message = "Nome tem tamanho mínimo de 3 e máximo de 10")
    @NotNull(message = "Nome não pode ser nulo")
    String name;

    @Email(message = "Login deve ser um email válido")
    @NotNull(message = "Login não pode ser nulo")
    String login;

    @Size(min = 3, max = 10, message = "Password tem tamanho mínimo de 3 e máximo de 10")
    @NotNull(message = "Password não pode ser nulo")
    String password;

    @NotNull(message = "Confirmação da senha deve ser informada.")
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
