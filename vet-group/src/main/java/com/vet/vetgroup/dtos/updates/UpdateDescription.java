package com.vet.vetgroup.dtos.updates;

import jakarta.validation.constraints.NotNull;

public class UpdateDescription {

    @NotNull
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
