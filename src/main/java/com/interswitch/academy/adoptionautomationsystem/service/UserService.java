package com.interswitch.academy.adoptionautomationsystem.service;

import com.interswitch.academy.adoptionautomationsystem.dto.RegistrationDto;
import com.interswitch.academy.adoptionautomationsystem.entities.User;

import java.util.List;

public interface UserService {

    List<RegistrationDto> findAllUsers();

    User findByEmail(String email);

    void saveUser(RegistrationDto registrationDto);

    RegistrationDto findUserById(String userId);
    void deleteUser(String userId);
}
