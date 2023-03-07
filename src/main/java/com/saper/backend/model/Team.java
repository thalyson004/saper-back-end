package com.saper.backend.model;

import jakarta.persistence.*;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // Professor responsável

    // Alunos matriculados

    @Column(name = "schedule")
    String schedule; //TODO: Mudar para DayOfWeek end LocalTime
    // 35_19 : terça e quinta às 19
    // 246_17 : segunda quarta e sexta, às 17

    @ManyToOne(targetEntity = Box.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "box_id")
    Box box;

    public Team() {
    }

    public Team(Long id, String schedule, Box box) {
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
