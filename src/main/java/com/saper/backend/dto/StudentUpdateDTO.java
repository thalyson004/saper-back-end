package com.saper.backend.dto;

public class StudentUpdateDTO {
    boolean paid;

    public StudentUpdateDTO(boolean paid) {
        this.paid = paid;
    }

    public StudentUpdateDTO() {
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
