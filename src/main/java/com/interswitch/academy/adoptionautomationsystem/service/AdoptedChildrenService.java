package com.interswitch.academy.adoptionautomationsystem.service;


import com.interswitch.academy.adoptionautomationsystem.dto.AdoptedChildrenDto;

import java.util.List;

public interface AdoptedChildrenService {

    List<AdoptedChildrenDto> findAllAdoptedChildren();
}
