package com.vet.vetgroup.dtos.updates;

import com.vet.vetgroup.models.Privilege;

import java.util.List;

public class NewPermissionsDto {

    private List<Privilege> privileges;

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
