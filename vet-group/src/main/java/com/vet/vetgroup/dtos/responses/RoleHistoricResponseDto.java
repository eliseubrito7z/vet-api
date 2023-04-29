package com.vet.vetgroup.dtos.responses;

import com.vet.vetgroup.models.Role;
import com.vet.vetgroup.models.Staff;

import java.time.LocalDateTime;

public class RoleHistoricResponseDto {

    private Long id;
    private LocalDateTime startedIn;
    private Integer baseSalary;
    private Integer weeklyWorkLoad;
    private Role role;
    private StaffReducedDto promoter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartedIn() {
        return startedIn;
    }

    public void setStartedIn(LocalDateTime startedIn) {
        this.startedIn = startedIn;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public StaffReducedDto getPromoter() {
        return promoter;
    }

    public void setPromoter(StaffReducedDto promoter) {
        this.promoter = promoter;
    }
}
