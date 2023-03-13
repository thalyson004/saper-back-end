package com.saper.backend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BoxRequestDTO {

    @Size(min = 3, max = 10, message = "Name tem tamanho mínimo de 3 e máximo de 10")
    @NotNull(message = "name não pode ser nulo")
    String name;

    @Min(value = 1, message = "Capacidade mínima do box é 5")
    @Max(value = 99, message = "Capacidade máxima do box é 99")
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
