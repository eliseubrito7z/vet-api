package com.vet.vetgroup.dtos.updates;

import jakarta.validation.constraints.NotNull;

public class NewPrivilegeDto {

    @NotNull
    private String privilege;

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
}
