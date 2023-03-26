package com.vet.vetgroup.dtos.responses;

import com.vet.vetgroup.models.Privilege;

import java.util.List;

public class RoleResponseDto {

    private String description;
    private List<Privilege> privileges;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

}
