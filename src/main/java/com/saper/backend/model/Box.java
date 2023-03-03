package com.saper.backend.model;

import jakarta.persistence.*;

@Entity(name = "box")
public class Box{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
        name = "box_id"
    )
    Long id;

    @Column(
        nullable = false
    )
    String name;

    @Column(
        nullable = false
    )
    int capacity;

    @Column(
        nullable = false
    )
    String created_by;

    public Box() {
    }

    public Box(Long id, String name, int capacity, String created_by) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.created_by = created_by;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
