package com.interswitch.academy.adoptionautomationsystem.mapper;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptionFormDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptionForm;

public class AdoptionFormMapper {

    public static AdoptionForm mapToAdoptionForm(AdoptionFormDto adoptionFormDto){

        return AdoptionForm.builder()
                .id(adoptionFormDto.getId())
               .adoptiveParent(adoptionFormDto.getAdoptiveParent())
                .dateOfAdoption(adoptionFormDto.getDateOfAdoption())
//                .descriptionOfCultureOnAdoption(adoptionFormDto.getDescriptionOfCultureOnAdoption())
                .preferredAgeOfChild(adoptionFormDto.getPreferredAgeOfChild())
                .durationOfAdoption(adoptionFormDto.getDurationOfAdoption())
                .files(adoptionFormDto.getFiles())
                .Witness(adoptionFormDto.getWitness())
                .inheritanceEligibility(adoptionFormDto.getInheritanceEligibility())
                .otherInfo(adoptionFormDto.getOtherInfo())
                .build();
    }

    public static AdoptionFormDto mapToAdoptionFormDto(AdoptionForm adoptionForm){

        return AdoptionFormDto.builder()
                .id(adoptionForm.getId())
               .adoptiveParent(adoptionForm.getAdoptiveParent())
                .dateOfAdoption(adoptionForm.getDateOfAdoption())
//                .descriptionOfCultureOnAdoption(adoptionForm.getDescriptionOfCultureOnAdoption())
                .preferredAgeOfChild(adoptionForm.getPreferredAgeOfChild())
                .durationOfAdoption(adoptionForm.getDurationOfAdoption())
                .files(adoptionForm.getFiles())
                .Witness(adoptionForm.getWitness())
                .inheritanceEligibility(adoptionForm.getInheritanceEligibility())
                .otherInfo(adoptionForm.getOtherInfo())
                .build();
    }
}
