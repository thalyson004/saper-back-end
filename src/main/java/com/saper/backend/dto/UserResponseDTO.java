package com.saper.backend.dto;

import com.saper.backend.model.User;

public class UserResponseDTO {
    String name;
    String login;

    Long student_id;

    public UserResponseDTO() {
    }

    public UserResponseDTO(String name, String login, Long student_id) {
        this.name = name;
        this.login = login;
        this.student_id = student_id;
    }

    public UserResponseDTO(User user) {
        this.name = user.getName();
        this.login = user.getLogin();
        this.student_id = user.getId();
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
