package com.saper.backend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BoxRequestDTO {
    @Size(message = "Nome do Box deve ser, no mínimo 5 e no máximo 50", min = 5, max = 50)
    @NotNull
    String name;

    @Min(message = "Capacidade mínima do Box é 5", value = 5)
    @Max(message = "Capacidade máxima do Box é 100", value = 100)
    @NotNull
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
