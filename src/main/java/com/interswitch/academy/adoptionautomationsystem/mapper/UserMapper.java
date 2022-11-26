package com.interswitch.academy.adoptionautomationsystem.mapper;

import com.interswitch.academy.adoptionautomationsystem.dto.RegistrationDto;
import com.interswitch.academy.adoptionautomationsystem.entities.User;


public class UserMapper {

    public static RegistrationDto mapToRegistrationDto(User user){

        return RegistrationDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRoles())
                .build();
    }
}
