package com.interswitch.academy.adoptionautomationsystem.dto;

import com.interswitch.academy.adoptionautomationsystem.entities.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.security.DenyAll;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuardianAdLitemDto {

    private String id;
    private String firstname;
    private String lastname;
    private Gender gender;
    private String phoneNumber;
    @Email
    private String email;
    private String location;
    private String report; //JQUERY CKEDITOR
}
