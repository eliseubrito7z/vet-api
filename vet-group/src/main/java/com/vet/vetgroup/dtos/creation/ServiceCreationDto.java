package com.vet.vetgroup.dtos.creation;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ServiceCreationDto {

    @NotNull
    private String reason;
    @NotNull
    private Date serviceDate;
    @NotNull
    private String type;
    @NotNull
    private String status;
    @NotNull
    private String paymentStatus;
    @NotNull
    private String city;
    @NotNull
    private Integer price;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
