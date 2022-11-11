package com.interswitch.academy.adoptionautomationsystem.mapper;

import com.interswitch.academy.adoptionautomationsystem.dto.GuardianAdLitemDto;
import com.interswitch.academy.adoptionautomationsystem.entities.GuardianAdLitem;

public class GuardianAdLitemMapper {

    public static GuardianAdLitem mapToGuardianAdLitem(GuardianAdLitemDto guardianAdLitemDto){

        return GuardianAdLitem.builder()
                .id(guardianAdLitemDto.getId())
                .firstname(guardianAdLitemDto.getFirstname())
                .lastname(guardianAdLitemDto.getLastname())
                .gender(guardianAdLitemDto.getGender())
                .email(guardianAdLitemDto.getEmail())
                .phoneNumber(guardianAdLitemDto.getPhoneNumber())
                .location(guardianAdLitemDto.getLocation())
                .report(guardianAdLitemDto.getReport())
                .build();
    }

    public static GuardianAdLitemDto mapToGuardianAdLitemDto(GuardianAdLitem guardianAdLitem){

        return GuardianAdLitemDto.builder()
                .id(guardianAdLitem.getId())
                .firstname(guardianAdLitem.getFirstname())
                .lastname(guardianAdLitem.getLastname())
                .gender(guardianAdLitem.getGender())
                .email(guardianAdLitem.getEmail())
                .phoneNumber(guardianAdLitem.getPhoneNumber())
                .location(guardianAdLitem.getLocation())
                .report(guardianAdLitem.getReport())
                .build();
    }
}
