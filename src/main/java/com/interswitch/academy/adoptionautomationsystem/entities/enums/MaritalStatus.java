package com.interswitch.academy.adoptionautomationsystem.entities.enums;

import lombok.Getter;

@Getter
public enum MaritalStatus {

    MARRIED("Married"),
    SINGLE("Single");
    private final String displayValue;

    MaritalStatus(String displayValue) {
        this.displayValue = displayValue;
    }
}
