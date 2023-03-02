package com.saper.backend.dto;

import com.saper.backend.model.Client;

public class ClientResponseDTO {
    String name;
    String login;

    public ClientResponseDTO(String name, String login) {
        this.name = name;
        this.login = login;
    }

    public ClientResponseDTO(Client client) {
        this.name = client.getName();
        this.login = client.getLogin();
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
}
