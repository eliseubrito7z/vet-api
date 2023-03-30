package com.vet.vetgroup.dtos.responses;

public class PatientLengthDto {

    private Integer total;
    private Integer today;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getToday() {
        return today;
    }

    public void setToday(Integer today) {
        this.today = today;
    }
}
