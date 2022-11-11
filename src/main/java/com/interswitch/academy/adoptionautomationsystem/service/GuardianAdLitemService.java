package com.interswitch.academy.adoptionautomationsystem.service;

import com.interswitch.academy.adoptionautomationsystem.dto.GuardianAdLitemDto;
import com.interswitch.academy.adoptionautomationsystem.entities.GuardianAdLitem;

import java.util.List;

public interface GuardianAdLitemService {

    List<GuardianAdLitemDto> findAllGuardians();

    GuardianAdLitem addStaff(GuardianAdLitemDto guardianAdLitemDto);
}
