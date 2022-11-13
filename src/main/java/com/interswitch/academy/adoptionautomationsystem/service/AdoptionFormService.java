package com.interswitch.academy.adoptionautomationsystem.service;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptionFormDto;
import com.interswitch.academy.adoptionautomationsystem.dto.AdoptiveParentDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptionForm;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;

import java.util.List;

public interface AdoptionFormService {

    List<AdoptionFormDto> findAllAdoptionForm();
    AdoptionForm createForm(AdoptionFormDto adoptionFormDto);
    AdoptionFormDto findFormById(String formId);

    void updateAdoptionForm(AdoptionFormDto formDto);
}
