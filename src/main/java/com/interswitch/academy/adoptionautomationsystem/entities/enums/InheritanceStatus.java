package com.interswitch.academy.adoptionautomationsystem.entities.enums;

import lombok.Getter;

public enum InheritanceStatus {

    AGREED("Agreed"),
    NOT_AGREED ("Not_Agreed");
    private final String displayValue;

    InheritanceStatus(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
