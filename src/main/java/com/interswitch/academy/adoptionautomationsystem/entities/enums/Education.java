package com.interswitch.academy.adoptionautomationsystem.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Education {

    SSCE("SSCE"),
    ND("ND"),
    HND("HND"),
    BSC("Bsc"),
    MSC("Msc"),
    PHD("Phd"),
    OTHERS("Others");
    private final String displayValue;

}
