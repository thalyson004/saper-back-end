package com.saper.backend.model;

import javax.persistence.*;

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

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    User user;

    @ManyToMany(
            targetEntity = Team.class,
            cascade = CascadeType.ALL)
    @JoinTable(name = "enrollment",
                joinColumns = @JoinColumn(name = "student_id"),
                inverseJoinColumns = @JoinColumn(name = "team_id"))
    Set<Team> teams;


    public Student() {
    }

    public Student(Long id, String registration, boolean paid, User user, Set<Team> teams) {
        this.id = id;
        this.registration = registration;
        this.paid = paid;
        this.user = user;
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

    public User getClient() {
        return user;
    }

    public void setClient(User user) {
        this.user = user;
    }
}
