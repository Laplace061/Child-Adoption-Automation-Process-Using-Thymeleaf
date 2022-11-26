package com.interswitch.academy.adoptionautomationsystem.dto;

import com.interswitch.academy.adoptionautomationsystem.entities.AdoptionRequest;
import com.interswitch.academy.adoptionautomationsystem.entities.Documents;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdoptiveParentDto {

    private String id;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotEmpty(message = "occupation cannot be empty")
    private String occupation;
    @NotNull(message = "choose a gender from the list")
    private Gender gender;
    @NotNull
    @Min(value = 25, message = "Sorry you are too young to adopt a child!!!")
    @Max(value = 99, message = "Sorry you are too old to adopt a child!!!")
    private int age;
    private MaritalStatus maritalStatus;
    private Religion religion;
    private Education qualification;
    private String nationality;
    @NotEmpty(message = "Official address cannot be empty")
    private String officialAddress;
    @NotEmpty(message = "Home address cannot be empty")
    private String homeAddress;
    private String phoneNumber;
    private AdoptionStatus status;
    private List<Documents> documents;
//    @OneToOne(mappedBy = "parentName")
//    private AdoptionRequest request;
}
