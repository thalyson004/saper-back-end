package com.saper.backend.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "registration")
    String registration;

    @Column(name = "paid")
    boolean paid;

    @OneToOne(targetEntity = Client.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    Client client;

    @ManyToMany(targetEntity = Team.class)
    @JoinTable(name = "enrollment")
    Set<Team> teams;

    public Student() {
    }

    public Student(Long id, String registration, boolean paid, Client client, Set<Team> teams) {
        this.id = id;
        this.registration = registration;
        this.paid = paid;
        this.client = client;
        this.teams = teams;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
