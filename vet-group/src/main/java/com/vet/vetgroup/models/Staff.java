package com.vet.vetgroup.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_staff")
public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(name = "avatar_url", nullable = true)
    private String avatarUrl;
    @Column(name = "base_salary", nullable = false)
    private Integer baseSalary;
    @Column(name = "on_duty", nullable = false)
    private Boolean onDuty;
    @Column(name = "weekly_work_load", nullable = true)
    private Integer weeklyWorkLoad;
    @Column(name = "work_load_completed", nullable = true)
    private Integer workLoadCompleted;

    @OneToMany(mappedBy = "medic")
    private List<Service> service;

    @OneToMany(mappedBy = "createdBy")
    private List<Report> report;

    @OneToMany(mappedBy = "approver")
    private List<Report> reportApprover;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "promoter")
    private List<RoleHistoric> promoterHistoric = new ArrayList<>();

    @OneToMany(mappedBy = "staff")
    private List<RoleHistoric> roleHistoric = new ArrayList<>();


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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Objects.equals(id, staff.id) && Objects.equals(createdAt, staff.createdAt) && Objects.equals(role, staff.role) && Objects.equals(fullName, staff.fullName) && Objects.equals(email, staff.email) && Objects.equals(cpf, staff.cpf) && Objects.equals(avatarUrl, staff.avatarUrl) && Objects.equals(baseSalary, staff.baseSalary) && Objects.equals(onDuty, staff.onDuty) && Objects.equals(weeklyWorkLoad, staff.weeklyWorkLoad) && Objects.equals(workLoadCompleted, staff.workLoadCompleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, role, fullName, email, cpf, avatarUrl, baseSalary, onDuty, weeklyWorkLoad, workLoadCompleted);
    }
}
