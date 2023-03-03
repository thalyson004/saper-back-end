package com.saper.backend.dto;

public class BoxRequestDTO {

    String name;

    int capacity;

    public BoxRequestDTO(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public BoxRequestDTO() {
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
}
