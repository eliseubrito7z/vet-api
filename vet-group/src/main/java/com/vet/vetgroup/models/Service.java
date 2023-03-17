package com.vet.vetgroup.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_services")
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;
    @Column(nullable = false, updatable = false)
    private String reason;
    @Column(name = "service_date", nullable = false, updatable = false)
    private Date serviceDate;
    @Column(nullable = false, updatable = false)
    private String type;
    @Column(nullable = false, updatable = false)
    private String status;
    @Column(name = "payment_status", nullable = false, updatable = false)
    private String paymentStatus;
    @Column(nullable = false, updatable = false)
    private String city;
    @Column(nullable = false, updatable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(id, service.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
