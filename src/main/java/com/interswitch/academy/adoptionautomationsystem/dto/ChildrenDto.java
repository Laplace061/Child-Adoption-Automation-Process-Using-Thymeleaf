package com.interswitch.academy.adoptionautomationsystem.dto;

import com.interswitch.academy.adoptionautomationsystem.entities.enums.AdoptionStatus;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChildrenDto {

    private String id;
    private String firstName;
    private String lastName;
    private String dob;
    private String motherName;
    private String fatherName;
    private Gender gender;
    private AdoptionStatus status;
    private String orphanageCode;
    private String nationality;
    private String image;
}
