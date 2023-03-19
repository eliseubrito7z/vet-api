package com.vet.vetgroup.models;

import com.vet.vetgroup.enums.PaymentStatus;
import com.vet.vetgroup.enums.ServiceStatus;
import com.vet.vetgroup.enums.ServiceTypes;
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
    private Integer type;
    @Column(nullable = false, updatable = false)
    private Integer status;
    @Column(name = "payment_status", nullable = false, updatable = false)
    private Integer paymentStatus;
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

    public ServiceTypes getType() {
        return ServiceTypes.valueOf(this.type);
    }

    public void setType(ServiceTypes type) {
        if (type != null) {
            this.type = type.getCode();
        }
    }

    public ServiceStatus getStatus() {
        return ServiceStatus.valueOf(this.status);
    }

    public void setStatus(ServiceStatus status) {
        if (status != null) {
            this.status = status.getCode();
        }
    }

    public PaymentStatus getPaymentStatus() {
        return PaymentStatus.valueOf(this.paymentStatus);
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        if (paymentStatus != null) {
            this.paymentStatus = paymentStatus.getCode();
        }
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
