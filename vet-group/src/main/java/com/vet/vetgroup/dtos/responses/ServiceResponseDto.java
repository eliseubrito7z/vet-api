package com.vet.vetgroup.dtos.responses;

import com.vet.vetgroup.dtos.reduceds.PatientReducedDto;
import com.vet.vetgroup.dtos.reduceds.StaffReducedDto;
import com.vet.vetgroup.models.City;

import java.util.Date;

public class ServiceResponseDto {

    private Long id;
    private Date createdAt;
    private String reason;
    private Date serviceDate;
    private String type;
    private String status;
    private String paymentStatus;
    private City city;
    private StaffReducedDto medic;
    private PatientReducedDto patient;
    private Integer price;

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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public StaffReducedDto getMedic() {
        return medic;
    }

    public void setMedic(StaffReducedDto medic) {
        this.medic = medic;
    }

    public PatientReducedDto getPatient() {
        return patient;
    }

    public void setPatient(PatientReducedDto patient) {
        this.patient = patient;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
