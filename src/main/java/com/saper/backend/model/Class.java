package com.saper.backend.model;

import jakarta.persistence.*;

import java.lang.annotation.Target;
import java.util.Date;

@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // Professor Responsável
    // Estudantes

    @Column(name = "schedule")
    String schedule; //TODO: mudar para Date

    @ManyToOne(targetEntity = Box.class)
    @JoinColumn(name = "box_id")
    Box box;

    public Class() {
    }

    public Class(Long id, String schedule, Box box) {
        this.id = id;
        this.schedule = schedule;
        this.box = box;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }
}
