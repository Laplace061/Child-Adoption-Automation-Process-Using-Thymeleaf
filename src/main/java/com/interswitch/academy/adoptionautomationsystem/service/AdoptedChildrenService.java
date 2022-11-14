package com.interswitch.academy.adoptionautomationsystem.service;


import com.interswitch.academy.adoptionautomationsystem.dto.AdoptedChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.dto.RequestDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptionRequest;
import com.interswitch.academy.adoptionautomationsystem.mapper.RequestMapper;

import java.util.List;

public interface AdoptedChildrenService {

    List<AdoptedChildrenDto> findAllAdoptedChildren();
    void deleteChild(String childId);
    AdoptedChildrenDto findAdoptedChildById(String childId);


}
