package com.interswitch.academy.adoptionautomationsystem.entities.enums;

import lombok.Getter;

@Getter
public enum Gender {

    MALE("Male"),
    FEMALE("Female");
    private final String displayValue;

    Gender(String displayValue) {
        this.displayValue = displayValue;
    }
}
