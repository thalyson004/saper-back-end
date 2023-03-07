package com.saper.backend.dto;

import com.saper.backend.model.Box;

import java.util.Set;
import java.util.stream.Collectors;

public class BoxResponseDTO {

    String name;

    int capacity;

    String created_by;

    Set<Long> teams;

    public BoxResponseDTO(String name, int capacity, String created_by, Set<Long> teams) {
        this.name = name;
        this.capacity = capacity;
        this.created_by = created_by;
        this.teams = teams;
    }

    public BoxResponseDTO() {
    }

    public BoxResponseDTO(Box box) {
        name = box.getName();
        capacity = box.getCapacity();
        created_by = box.getCreated_by();
        teams = box.getTeams().stream().map(team -> team.getId()).collect(Collectors.toSet());
    }

    public Set<Long> getTeams() {
        return teams;
    }

    public void setTeams(Set<Long> teams) {
        this.teams = teams;
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
