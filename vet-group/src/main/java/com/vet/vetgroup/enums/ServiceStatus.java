package com.vet.vetgroup.enums;

public enum ServiceStatus {

    SCHEDULED(1),
    NOT_INITIALIZED(2),
    IN_PROGRESS(4),
    COMPLETED(5);

    private int code;

    private ServiceStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ServiceStatus valueOf(int code) {
        for (ServiceStatus value : ServiceStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Service Status code");
    }
}
