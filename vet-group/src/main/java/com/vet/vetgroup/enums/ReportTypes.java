package com.vet.vetgroup.enums;

public enum ReportTypes {

    REPORT(1),
    REQUEST(2),
    PAYMENT(3);

    private int code;

    private ReportTypes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ReportTypes valueOf(int code) {
        for (ReportTypes value : ReportTypes.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Report Type code");
    }
}
