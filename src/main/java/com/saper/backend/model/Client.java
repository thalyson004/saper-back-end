package com.saper.backend.model;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    Long id;

    @Column(
            nullable = false
    )
    String name;
    @Column(
        nullable = false,
        unique = true
    )
    String login;
    @Column(
        nullable = false
    )
    String password;

    @OneToOne(targetEntity = Student.class, cascade = CascadeType.ALL, mappedBy = "client")
    Student student;

    public Client(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
