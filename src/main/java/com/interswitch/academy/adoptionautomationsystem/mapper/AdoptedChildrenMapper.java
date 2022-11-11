package com.interswitch.academy.adoptionautomationsystem.mapper;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptedChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptedChildren;

public class AdoptedChildrenMapper {

    public static AdoptedChildrenDto mapToAdoptedChildrenDto(AdoptedChildren adoptedChildren){

        return AdoptedChildrenDto.builder()
                .id(adoptedChildren.getId())
                .parent(adoptedChildren.getParent())
                .leaveDate(adoptedChildren.getLeaveDate())
                .proofOfAdoption(adoptedChildren.getProofOfAdoption())
                .build();
    }

    public static AdoptedChildren mapToAdoptedChildren(AdoptedChildrenDto adoptedChildrenDto){

        return AdoptedChildren.builder()
                .id(adoptedChildrenDto.getId())
                .parent(adoptedChildrenDto.getParent())
                .leaveDate(adoptedChildrenDto.getLeaveDate())
                .proofOfAdoption(adoptedChildrenDto.getProofOfAdoption())
                .build();
    }
}
