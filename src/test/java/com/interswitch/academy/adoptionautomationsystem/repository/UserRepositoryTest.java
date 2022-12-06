package com.interswitch.academy.adoptionautomationsystem.repository;

import com.interswitch.academy.adoptionautomationsystem.dto.RegistrationDto;
import com.interswitch.academy.adoptionautomationsystem.entities.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void ShouldCreateUser() {

      User user1 =  User.builder()
                .id("1234")
                .name("Lamina")
                .email("lam@gmail.com")
              .password("12345678")
                .build();

        userRepository.save(user1);
        Assert.assertNotNull(userRepository.findByEmail("lam@gmail.com"));
    }
}
