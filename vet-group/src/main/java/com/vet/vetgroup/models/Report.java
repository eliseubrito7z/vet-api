package com.vet.vetgroup.models;

import com.vet.vetgroup.enums.ReportTypes;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_reports")
public class Report implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = false, length = 70)
    private String title;
    @Column(nullable = false, unique = false)
    private String description;
    @Column(name = "payment_value", nullable = true, unique = false)
    private Integer paymentValue;
    @Column(nullable = false, unique = false)
    private Integer type;
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;
    @Column(nullable = true, unique = false)
    private Boolean approved;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private Staff createdBy;

    @ManyToOne
    @JoinColumn(name = "approver", referencedColumnName = "id")
    private Staff approver;

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
        return ReportTypes.valueOf(type);
    }

    public void setType(ReportTypes type) {
        if (type != null) {
            this.type = type.getCode();
        }
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

    public Staff getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Staff createdBy) {
        this.createdBy = createdBy;
    }

    public Staff getApprover() {
        return approver;
    }

    public void setApprover(Staff approver) {
        this.approver = approver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        return Objects.equals(id, report.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
