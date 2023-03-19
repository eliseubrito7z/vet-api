package com.vet.vetgroup.enums;

public enum ServiceTypes {

    EXAM(1),
    SURGERY(2),
    MEDICAL_CARE(3),
    EMERGENCY(4);

    private int code;

    private ServiceTypes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ServiceTypes valueOf(int code) {
        for (ServiceTypes value : ServiceTypes.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Service type code");
    }
}
