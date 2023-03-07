package com.saper.backend.dto;

import com.saper.backend.model.Client;
import com.saper.backend.model.Student;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class StudentResponseDTO {
    Long id;
    String registration;
    boolean paid;
    Long client_id;

    public StudentResponseDTO(Student student) {
        id = student.getId();
        registration = student.getRegistration();
        paid = student.isPaid();
        client_id = student.getClient().getId();
    }

    public StudentResponseDTO() {
    }

    public StudentResponseDTO(Long id, String registration, boolean paid, Long client_id) {
        this.id = id;
        this.registration = registration;
        this.paid = paid;
        this.client_id = client_id;
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

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }
}
