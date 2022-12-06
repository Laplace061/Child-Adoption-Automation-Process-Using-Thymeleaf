package com.interswitch.academy.adoptionautomationsystem.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AdoptionStatus {

    INACTIVE("Inactive"),
    PROBATION("Probation"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    SUSPENDED("Suspended"),
    BARRED("Barred");
    private final String displayValue;
}
