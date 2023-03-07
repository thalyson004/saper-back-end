package com.saper.backend.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity(name = "box")
public class Box{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "box_id")
    Long id;

    String name;

    int capacity;

    String created_by;


    @OneToMany(targetEntity = Team.class,
            cascade = CascadeType.ALL,
            mappedBy = "box")
    Set<Team> teams;

    public Box() {
    }

    public Box(Long id, String name, int capacity, String created_by, Set<Team> teams) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.created_by = created_by;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
