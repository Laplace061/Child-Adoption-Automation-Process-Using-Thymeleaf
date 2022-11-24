package com.interswitch.academy.adoptionautomationsystem.mapper;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptiveParentDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import lombok.Builder;

@Builder
public class AdoptiveParentMapper {

    public static AdoptiveParentDto mapToAdoptiveParentDto(AdoptiveParent parent){
        return AdoptiveParentDto.builder()
                .id(parent.getId())
                .name(parent.getName())
                .gender(parent.getGender())
                .age(parent.getAge())
                .nationality(parent.getNationality())
                .religion(parent.getReligion())
                .maritalStatus(parent.getMaritalStatus())
                .phoneNumber(parent.getPhoneNumber())
                .occupation(parent.getOccupation())
                .qualification(parent.getQualification())
                .homeAddress(parent.getHomeAddress())
                .officialAddress(parent.getOfficialAddress())
//                .documents(parent.getDocuments())
                .status(parent.getStatus())
                .build();
    }

    public static AdoptiveParent mapToAdoptiveParent(AdoptiveParentDto parentDto){

        return AdoptiveParent.builder()
                .id(parentDto.getId())
                .name(parentDto.getName())
                .gender(parentDto.getGender())
                .age(parentDto.getAge())
                .nationality(parentDto.getNationality())
                .religion(parentDto.getReligion())
                .maritalStatus(parentDto.getMaritalStatus())
                .phoneNumber(parentDto.getPhoneNumber())
                .occupation(parentDto.getOccupation())
                .qualification(parentDto.getQualification())
                .homeAddress(parentDto.getHomeAddress())
                .officialAddress(parentDto.getOfficialAddress())
                .status(parentDto.getStatus()) //INACTIVE, PROBATION, IN PROGRESS, COMPLETED
                .build();
    }
}
