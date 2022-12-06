package com.interswitch.academy.adoptionautomationsystem.service.serviceImpl;

import com.interswitch.academy.adoptionautomationsystem.dto.RegistrationDto;
import com.interswitch.academy.adoptionautomationsystem.entities.Children;
import com.interswitch.academy.adoptionautomationsystem.entities.Role;
import com.interswitch.academy.adoptionautomationsystem.entities.User;
import com.interswitch.academy.adoptionautomationsystem.mapper.ChildrenMapper;
import com.interswitch.academy.adoptionautomationsystem.mapper.UserMapper;
import com.interswitch.academy.adoptionautomationsystem.repository.RoleRepository;
import com.interswitch.academy.adoptionautomationsystem.repository.UserRepository;
import com.interswitch.academy.adoptionautomationsystem.service.UserService;
import com.interswitch.academy.adoptionautomationsystem.util.IdUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private RoleRepository roleRepository;
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;
    private IdUtil idUtil;


    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, IdUtil idUtil) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.idUtil = idUtil;
    }

    @Override
    public List<RegistrationDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.mapToRegistrationDto(user))
                .collect(Collectors.toList());
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
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN"); // Create the role inside the database
        user.setRoles(Arrays.asList(role));
        String userId = idUtil.generateId();
        user.setId(userId);
        userRepository.save(user);
    }

    @Override
    public RegistrationDto findUserById(String userId) {
            User user = userRepository.findById(userId).get();
            return UserMapper.mapToRegistrationDto(user);
        }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

}
