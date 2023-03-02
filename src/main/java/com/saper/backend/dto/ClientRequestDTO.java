package com.saper.backend.dto;

import com.saper.backend.model.Client;

public class ClientRequestDTO {
    String name;
    String login;
    String password;
    String repeated_password;

    public ClientRequestDTO(String name, String login, String password, String repeated_password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.repeated_password = repeated_password;
    }

    public ClientRequestDTO(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public ClientRequestDTO() {
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

    public Client toClient() {
        Client client = new Client();
        client.setName(name);
        client.setPassword(password);
        client.setLogin(login);
        return client;
    }
}
