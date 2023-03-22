package com.vet.vetgroup.dtos.responses;

import java.util.Date;

public class ReportResponseDto {
    private Long id;
    private String title;
    private String description;
    private Integer paymentValue;
    private Integer type;
    private Date createdAt;
    private Boolean approved;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
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
}
