package com.saper.backend.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // Professor Responsável

    // Estudantes
    @ManyToMany(targetEntity = Student.class, mappedBy = "teams")
    Set<Student> students;

    @Column(name = "schedule")
    String schedule; //TODO: mudar para DayOfWeek e LocalTime

    @ManyToOne(targetEntity = Box.class)
    @JoinColumn(name = "box_id")
    Box box;

    public Team() {
    }

    public Team(Long id, Set<Student> students, String schedule, Box box) {
        this.id = id;
        this.students = students;
        this.schedule = schedule;
        this.box = box;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
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
