package com.vet.vetgroup.dtos.responses;

import com.vet.vetgroup.enums.ReportTypes;

import java.util.Date;

public class ReportResponseDto {
    private Long id;
    private String title;
    private String description;
    private Integer paymentValue;
    private ReportTypes type;
    private Date createdAt;
    private Boolean approved;
    private StaffReducedDto createdBy;
    private StaffReducedDto approver;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(Integer paymentValue) {
        this.paymentValue = paymentValue;
    }

    public ReportTypes getType() {
        return type;
    }

    public void setType(ReportTypes type) {
        this.type = type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public StaffReducedDto getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(StaffReducedDto createdBy) {
        this.createdBy = createdBy;
    }

    public StaffReducedDto getApprover() {
        return approver;
    }

    public void setApprover(StaffReducedDto approver) {
        this.approver = approver;
    }
}
