package com.interswitch.academy.adoptionautomationsystem.dto;

import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.Document;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.InheritanceEligibility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
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

    private InheritanceEligibility inheritanceEligibility;

    @PastOrPresent(message = "cannot enter a future date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfAdoption;

    @Size(min = 10, max = 200, message
            = "info must be between 10 and 200 characters")
    private String otherInfo;

    private Set<Document> files;

    @Size(min = 2, message = "Input too short")
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input, Numbers and symbols not allowed")
    @NotEmpty(message = "Please provide a witness")
    private String Witness;
}
