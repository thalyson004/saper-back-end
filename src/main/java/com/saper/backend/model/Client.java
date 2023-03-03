package com.saper.backend.model;

import jakarta.persistence.*;

@Entity(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
        name = "client_id"
    )
    Long id;
    String name;
    @Column(
        name = "login",
        nullable = false,
        unique = true
    )
    String login;
    @Column(
            name = "password",
            nullable = false
    )
    String password;

    public Client(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public Client() {
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
}
