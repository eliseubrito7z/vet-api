package com.vet.vetgroup.dtos.updates;

import com.vet.vetgroup.models.Privilege;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class NewPermissionsDto {

    @NotNull
    private List<Privilege> privileges;

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
