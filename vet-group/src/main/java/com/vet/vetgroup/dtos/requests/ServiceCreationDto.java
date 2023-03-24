package com.vet.vetgroup.dtos.requests;

import com.vet.vetgroup.enums.PaymentStatus;
import com.vet.vetgroup.enums.ServiceStatus;
import com.vet.vetgroup.enums.ServiceTypes;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ServiceCreationDto {

    @NotNull
    private String reason;
    @NotNull
    private String serviceDate;
    private ServiceTypes type;
    private ServiceStatus status;
    private PaymentStatus paymentStatus;
    @NotNull
    private Long patientId;
    @NotNull
    private Long medicId;
    @NotNull
    private String cityNameAndUF;
    @NotNull
    private Integer price;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public ServiceTypes getType() {
        return type;
    }

    public void setType(ServiceTypes type) {
        this.type = type;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getMedicId() {
        return medicId;
    }

    public void setMedicId(Long medicId) {
        this.medicId = medicId;
    }

    public String getCityNameAndUF() {
        return cityNameAndUF;
    }

    public void setCityNameAndUF(String cityNameAndUF) {
        this.cityNameAndUF = cityNameAndUF;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
