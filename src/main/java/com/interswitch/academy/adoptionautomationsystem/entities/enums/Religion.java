package com.interswitch.academy.adoptionautomationsystem.entities.enums;

import lombok.Getter;

@Getter
public enum Religion {

    CHRISTIAN("Christianity"),
    ISLAM("Islam"),
    OTHERS("Others");
    private final String displayValue;

    Religion(String displayValue) {
        this.displayValue = displayValue;
    }
}
