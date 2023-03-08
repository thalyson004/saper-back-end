package com.saper.backend.dto;

import com.saper.backend.model.Client;

public class ClientResponseDTO {
    String name;
    String login;

    Long student_id;

    public ClientResponseDTO() {
    }

    public ClientResponseDTO(String name, String login, Long student_id) {
        this.name = name;
        this.login = login;
        this.student_id = student_id;
    }

    public ClientResponseDTO(Client client) {
        this.name = client.getName();
        this.login = client.getLogin();
        this.student_id = client.getId();
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
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
