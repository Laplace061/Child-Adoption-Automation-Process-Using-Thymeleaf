package com.interswitch.academy.adoptionautomationsystem.service;

import com.interswitch.academy.adoptionautomationsystem.dto.RequestDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptionRequest;

import java.util.List;

public interface AdoptionRequestService {

    List<RequestDto> findAllRequest();

    AdoptionRequest createRequest(RequestDto requestDto);

    //   String getParentName(int id);

    RequestDto findRequestById(String requestId);

    void updateRequest(RequestDto requestDto);
}
