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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuardianAdLitemDto {

    private String id;
    @NotEmpty()
    @Size(min = 2, message = "FirstName too short")
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input, Numbers and symbols not allowed")
    private String firstname;

    @NotEmpty()
    @Size(min = 2, message = "FirstName too short")
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input, Numbers and symbols not allowed")
    private String lastname;

    private Gender gender;
    private String phoneNumber;

    @NotEmpty(message = "Email cannot be blank.")
    @Email(message = "Enter a valid email")
    private String email;

    private String location;
    private String report; //JQUERY CKEDITOR
}
