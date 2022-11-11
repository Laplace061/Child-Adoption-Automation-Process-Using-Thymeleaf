package com.interswitch.academy.adoptionautomationsystem.service;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptionFormDto;

import java.util.List;

public interface AdoptionFormService {

    List<AdoptionFormDto> findAllAdoptionForm();
}
