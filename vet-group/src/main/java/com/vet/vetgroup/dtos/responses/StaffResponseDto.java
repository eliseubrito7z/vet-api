package com.vet.vetgroup.dtos.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vet.vetgroup.models.Role;
import com.vet.vetgroup.models.Service;

import java.time.LocalDateTime;
import java.util.List;

public class StaffResponseDto {

    private Long id;
    private LocalDateTime createdAt;
    private Role role;
    private String fullName;
    private String email;
    private String cpf;
    private String avatarUrl;
    private Integer baseSalary;
    private Boolean onDuty;
    private Integer weeklyWorkLoad;
    private Integer workLoadCompleted;
    private List<RoleHistoricResponseDto> roleHistoric;
    private List<ServiceResponseDto> servicesList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Integer baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Boolean getOnDuty() {
        return onDuty;
    }

    public void setOnDuty(Boolean onDuty) {
        this.onDuty = onDuty;
    }

    public Integer getWeeklyWorkLoad() {
        return weeklyWorkLoad;
    }

    public void setWeeklyWorkLoad(Integer weeklyWorkLoad) {
        this.weeklyWorkLoad = weeklyWorkLoad;
    }

    public Integer getWorkLoadCompleted() {
        return workLoadCompleted;
    }

    public void setWorkLoadCompleted(Integer workLoadCompleted) {
        this.workLoadCompleted = workLoadCompleted;
    }

    public List<RoleHistoricResponseDto> getRoleHistoric() {
        return roleHistoric;
    }

    public void setRoleHistoric(List<RoleHistoricResponseDto> roleHistoric) {
        this.roleHistoric = roleHistoric;
    }

    public List<ServiceResponseDto> getServicesList() {
        return servicesList;
    }

    public void setServicesList(List<ServiceResponseDto> servicesList) {
        this.servicesList = servicesList;
    }
}
