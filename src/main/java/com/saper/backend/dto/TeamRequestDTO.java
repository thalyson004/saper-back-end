package com.saper.backend.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class TeamRequestDTO {
    String schedule;
    Long box_id;

    public TeamRequestDTO(String schedule, Long box_id) {
        this.schedule = schedule;
        this.box_id = box_id;
    }

    public TeamRequestDTO() {
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
