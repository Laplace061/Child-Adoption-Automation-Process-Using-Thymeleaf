package com.interswitch.academy.adoptionautomationsystem.service.serviceImpl;

import com.interswitch.academy.adoptionautomationsystem.dto.ChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.dto.RegistrationDto;
import com.interswitch.academy.adoptionautomationsystem.entities.Role;
import com.interswitch.academy.adoptionautomationsystem.entities.User;
import com.interswitch.academy.adoptionautomationsystem.repository.RoleRepository;
import com.interswitch.academy.adoptionautomationsystem.repository.UserRepository;
import com.interswitch.academy.adoptionautomationsystem.service.UserService;
import com.interswitch.academy.adoptionautomationsystem.util.IdUtil;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private IdUtil idUtil;


    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository, IdUtil idUtil) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.idUtil = idUtil;
    }

    @Override
    public User findByEmail(String email) {

            return userRepository.findByEmail(email);
        }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setName(registrationDto.getFirstName() + " " + registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        // use spring security to encrypt the password
//        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("ROLE_USER"); // Create the role inside the database
        user.setRoles(Arrays.asList(role));
        String childId = idUtil.generateId(); // UUID.randomUUID().toString() was moved to the Util class
        user.setId(childId);
        userRepository.save(user);
    }
}
