package com.interswitch.academy.adoptionautomationsystem.entities.enums;

public enum InheritanceEligibility {

    AGREED("Agreed"),
    NOT_AGREED ("Not_Agreed");
    private final String displayValue;

    InheritanceEligibility(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
