package com.interswitch.academy.adoptionautomationsystem.repository;

import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.Education;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.Gender;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.MaritalStatus;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.Religion;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ParentRepoTest {
        @Autowired
        private AdoptiveParentRepository parentRepository;

        @Test
        public void ShouldCreateParent() {

           AdoptiveParent parent1 = AdoptiveParent.builder()
                    .id("1234")
                    .name("Bala")
                    .gender(Gender.MALE)
                    .age(65)
                    .nationality("Nigerian")
                    .religion(Religion.CHRISTIAN)
                    .maritalStatus(MaritalStatus.SINGLE)
                    .phoneNumber("08033542617")
                    .occupation("engineer")
                    .qualification(Education.OTHERS)
                    .homeAddress("tunde street")
                    .officialAddress("bello street")
                    .build();
            parentRepository.save(parent1);
            Assert.assertNotNull(parentRepository.findAdoptiveParentByName("Bala"));
        }
    }

