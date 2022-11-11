package com.interswitch.academy.adoptionautomationsystem.entities.enums;

public enum RequestStatus {

    PENDING("Pending"),
    GRANTED("Granted"),
    REVOKE("Revoke");
    private final String displayValue;

    private RequestStatus(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
