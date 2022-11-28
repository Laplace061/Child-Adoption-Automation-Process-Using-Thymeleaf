package com.interswitch.academy.adoptionautomationsystem.dto;

import com.interswitch.academy.adoptionautomationsystem.entities.Role;
import com.interswitch.academy.adoptionautomationsystem.entities.User;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationDto {

    private String id;
    @NotEmpty(message = "first name cannot be blank")
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input, Numbers and symbols not allowed")
    private String firstName;

    @NotEmpty(message = "first name cannot be blank")
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input, Numbers and symbols not allowed")
    private String lastName;

    @NotEmpty(message = "Email cannot be blank.")
    @Email(message = "Enter a valid email")
    private String email;

    @NotEmpty(message = "Password cannot be blank.")
    @Size(min = 4, message = "Password too short. It should not be less than 4 characters")
    private String password;

    List<Role> role;
    private String name;
}
