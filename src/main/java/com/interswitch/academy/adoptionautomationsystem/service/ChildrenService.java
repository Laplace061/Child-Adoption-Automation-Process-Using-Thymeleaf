package com.interswitch.academy.adoptionautomationsystem.service;

import com.interswitch.academy.adoptionautomationsystem.dto.ChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.entities.Children;

import java.util.List;

public interface ChildrenService {

    List<ChildrenDto> findAllChildren();
    Children addChild(ChildrenDto childrenDto);
}
