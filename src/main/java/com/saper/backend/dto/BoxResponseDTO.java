package com.saper.backend.dto;

import com.saper.backend.model.Box;

public class BoxResponseDTO {

    String name;

    int capacity;

    String created_by;

    public BoxResponseDTO(String name, int capacity, String created_by) {
        this.name = name;
        this.capacity = capacity;
        this.created_by = created_by;
    }

    public BoxResponseDTO() {
    }

    public BoxResponseDTO(Box box) {
        name = box.getName();
        capacity = box.getCapacity();
        created_by = box.getCreated_by();

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
