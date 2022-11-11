package com.interswitch.academy.adoptionautomationsystem.dto;

import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.Documents;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdoptionFormDto {
    private String id;
    private AdoptiveParent adoptiveParent;
    private int preferredAgeOfChild;
    private int durationOfAdoption;
    private boolean inheritanceStatus;
    private LocalDateTime dateOfAdoption;
    private String descriptionOfCultureOnAdoption;
    private String otherInfo;
    private Set<Documents> files;
    private String Witness;
//    private LocalDateTime dateOfAdoption; pre persist or else enter manually
}
