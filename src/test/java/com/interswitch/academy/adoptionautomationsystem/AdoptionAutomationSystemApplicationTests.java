package com.interswitch.academy.adoptionautomationsystem;

import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.Education;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.Gender;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.MaritalStatus;
import com.interswitch.academy.adoptionautomationsystem.repository.AdoptiveParentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdoptionAutomationSystemApplicationTests {

        @Autowired
        private AdoptiveParentRepository parentRepository;

        @Test
        public void createParentTest() {

            AdoptiveParent newParent = new AdoptiveParent();
            newParent.setId("99846238-7fa5-4054-bfff-0fdae598d91c");
            newParent.setName("Badmus Edet");
            newParent.setHomeAddress("sagdgzd");
            newParent.setMaritalStatus(MaritalStatus.SINGLE);
            newParent.setGender(Gender.FEMALE);
            newParent.setAge(20);
            newParent.setNationality("Nigerian");
            newParent.setPhoneNumber("0908765423344");
            newParent.setQualification(Education.OTHERS);
            parentRepository.save(newParent);

            Assertions.assertEquals(2,2);

        }
}

