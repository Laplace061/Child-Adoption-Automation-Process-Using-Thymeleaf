package com.interswitch.academy.adoptionautomationsystem.dto;

import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.GuardianAdLitem;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.AdoptionStatus;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.Gender;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChildrenDto {

    private String id;
    private AdoptiveParent parent;
    private GuardianAdLitem guardian;
    @NotEmpty()
    @Size(min = 2, message = "FirstName too short")
    private String firstName;
    @NotBlank()
    @Size(min = 2, message = "LastName too short")
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Future date not allowed here")
    private Date dob;
    private String motherName;
    private String fatherName;
    private Gender gender;
    private AdoptionStatus status;
    @NotEmpty(message = "Orphanage code is required.")
    @Size(min = 10, max = 10, message = "code too long or too short. Please enter the correct code")
    private String orphanageCode;
    private String nationality;
    private String image;
}
