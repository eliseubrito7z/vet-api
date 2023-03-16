package com.vet.vetgroup.dtos.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

public class StaffResponseDto {

    private Long id;
    private Date createdAt;
    private String role;
    private String fullName;
    private String email;
    private String avatarUrl;
    private Integer baseSalary;
    private Boolean onDuty;
    private Integer weeklyWorkLoad;
    private Integer workLoadCompleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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
}
