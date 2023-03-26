package com.vet.vetgroup.dtos.requests;

import jakarta.validation.constraints.NotNull;

public class RoleHistoricCreationDto {

    @NotNull
    private String roleDescription;
    @NotNull
    private Integer baseSalary;
    @NotNull
    private Integer weeklyWorkLoad;
    @NotNull
    private Long staff_id;

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Integer getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Integer baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Integer getWeeklyWorkLoad() {
        return weeklyWorkLoad;
    }

    public void setWeeklyWorkLoad(Integer weeklyWorkLoad) {
        this.weeklyWorkLoad = weeklyWorkLoad;
    }


    public Long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Long staff_id) {
        this.staff_id = staff_id;
    }
}
