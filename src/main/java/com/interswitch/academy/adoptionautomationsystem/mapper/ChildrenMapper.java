package com.interswitch.academy.adoptionautomationsystem.mapper;

import com.interswitch.academy.adoptionautomationsystem.dto.ChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.entities.Children;

import java.sql.Date;

public class ChildrenMapper {

    public static Children mapToChildren(ChildrenDto childrenDto){

        return Children.builder()
                .id(childrenDto.getId())
                .firstName(childrenDto.getFirstName())
                .lastName(childrenDto.getLastName())
                .gender(childrenDto.getGender())
                .dob(childrenDto.getDob())
                .fatherName(childrenDto.getFatherName())
                .motherName(childrenDto.getMotherName())
                .nationality(childrenDto.getNationality())
                .orphanageCode(childrenDto.getOrphanageCode())
                .status(childrenDto.getStatus())
                .image(childrenDto.getImage())
                .build();
    }

    public static ChildrenDto mapToChildrenDto(Children children){

        return ChildrenDto.builder()
                .id(children.getId())
                .firstName(children.getFirstName())
                .lastName(children.getLastName())
                .gender(children.getGender())
                .dob(children.getDob())
                .fatherName(children.getFatherName())
                .motherName(children.getMotherName())
                .nationality(children.getNationality())
                .orphanageCode(children.getOrphanageCode())
                .status(children.getStatus())
                .image(children.getImage())
                .build();
    }
}
