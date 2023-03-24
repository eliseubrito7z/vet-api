package com.vet.vetgroup.dtos.requests;

import jakarta.validation.constraints.NotNull;

public class CityCreationDto {

    @NotNull
    private String nameAndUF;

    public String getNameAndUF() {
        return nameAndUF;
    }

    public void setNameAndUF(String nameAndUF) {
        this.nameAndUF = nameAndUF;
    }
}
