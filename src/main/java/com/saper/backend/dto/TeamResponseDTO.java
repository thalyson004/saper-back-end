package com.saper.backend.dto;

import com.saper.backend.model.Team;

public class TeamResponseDTO {

    String schedule;
    Long box_id;

    public TeamResponseDTO() {
    }

    public TeamResponseDTO(String schedule, Long box_id) {
        this.schedule = schedule;
        this.box_id = box_id;
    }

    public TeamResponseDTO (Team team) {
        this.schedule = team.getSchedule();
        this.box_id = team.getBox().getId();
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
