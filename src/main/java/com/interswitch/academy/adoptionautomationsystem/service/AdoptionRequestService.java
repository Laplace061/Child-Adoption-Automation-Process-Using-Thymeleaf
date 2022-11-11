package com.interswitch.academy.adoptionautomationsystem.service;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptiveParentDto;
import com.interswitch.academy.adoptionautomationsystem.dto.RequestDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptionRequest;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;

import java.util.List;

public interface AdoptionRequestService {

    List<RequestDto> findAllRequest();

    AdoptionRequest createRequest(RequestDto requestDto);

//   String getParentName(int id);
}
