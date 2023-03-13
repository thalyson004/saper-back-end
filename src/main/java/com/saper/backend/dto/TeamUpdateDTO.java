package com.saper.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class TeamUpdateDTO {

    @NotBlank
    String  schedule;
//    Long box_id; //TODO: Mudar o box

    public TeamUpdateDTO(String schedule) {
        this.schedule = schedule;
    }

    public TeamUpdateDTO() {
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
