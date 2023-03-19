package com.vet.vetgroup.dtos.reduceds;

import com.vet.vetgroup.models.Role;

import java.util.Date;

public class StaffReducedDto {

    private Long id;
    private Role role;
    private String fullName;
    private String avatarUrl;
    private Boolean onDuty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Boolean getOnDuty() {
        return onDuty;
    }

    public void setOnDuty(Boolean onDuty) {
        this.onDuty = onDuty;
    }
}
