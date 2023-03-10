package com.saper.backend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BoxRequestDTO {

    @Size(min = 5, max = 20, message = "O nome do Box deve ter tamanho mínimo de 5 e máximo de 20.")
    @NotNull
    String name;

    @Min(value = 10, message = "Capacidade mínima é 10.")
    @Max(value = 99, message = "Capacidade máxima é 99.")
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
