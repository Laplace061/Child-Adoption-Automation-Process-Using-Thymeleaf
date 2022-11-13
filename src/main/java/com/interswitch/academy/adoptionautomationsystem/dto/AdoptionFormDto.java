package com.interswitch.academy.adoptionautomationsystem.dto;

import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.Documents;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.InheritanceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdoptionFormDto {
    private String id;
    private AdoptiveParent adoptiveParent;
    @Max(value = 18, message = "Sorry child is too old to be adopted, Enter age from 1 - 18")
    private int preferredAgeOfChild;
    private int durationOfAdoption;
    private InheritanceStatus inheritanceStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfAdoption;
//    private String descriptionOfCultureOnAdoption;
    private String otherInfo;
    private Set<Documents> files;
    @NotEmpty(message = "Please provide a witness")
    private String Witness;
}
