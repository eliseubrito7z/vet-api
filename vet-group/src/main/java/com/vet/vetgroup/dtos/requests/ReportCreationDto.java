package com.vet.vetgroup.dtos.requests;

import com.vet.vetgroup.enums.ReportTypes;
import jakarta.validation.constraints.NotNull;

public class ReportCreationDto {

    @NotNull
    private String title;
    @NotNull
    private String description;
    private Integer paymentValue;
    @NotNull
    private ReportTypes type;

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
}
