package com.saper.backend.dto;

import com.saper.backend.model.Team;

import java.util.Set;
import java.util.stream.Collectors;

public class TeamResponseDTO {

    String schedule;
    Long box_id;

    Set<Long> students;

    public TeamResponseDTO() {
    }

    public TeamResponseDTO(String schedule, Long box_id, Set<Long> students) {
        this.schedule = schedule;
        this.box_id = box_id;
        this.students = students;
    }

    public Set<Long> getStudents() {
        return students;
    }

    public void setStudents(Set<Long> students) {
        this.students = students;
    }

    public TeamResponseDTO (Team team) {
        schedule = team.getSchedule();
        box_id = team.getBox().getId();
        students = team.getStudents().stream().map(t -> t.getId()).collect(Collectors.toSet());
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Long getBox_id() {
        return box_id;
    }

    public void setBox_id(Long box_id) {
        this.box_id = box_id;
    }
}
