package com.interswitch.academy.adoptionautomationsystem.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AdoptionStatus {

    INACTIVE("Inactive"),
    PROBATION("Probation"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed");
    private final String displayValue;
}
