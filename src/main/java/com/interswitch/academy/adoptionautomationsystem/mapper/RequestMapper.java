package com.interswitch.academy.adoptionautomationsystem.mapper;

import com.interswitch.academy.adoptionautomationsystem.dto.RequestDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptionRequest;
import lombok.Builder;

@Builder
public class RequestMapper {

    //Map post entity to RequestDto

    public static RequestDto mapToRequestDto(AdoptionRequest request) {

        RequestDto requestForm = RequestDto.builder()
                .id(request.getId())
                .location(request.getLocation())
                .reasonOrPurposeForAdoption(request.getReasonOrPurposeForAdoption())
                .requestDate(request.getRequestDate())
                .status(request.getStatus())
                .parent(request.getParent())
                .build();

        return requestForm;
        // return PostDto.builder()    We can return like this as done in the nxt method
    }

    public static AdoptionRequest mapToRequest(RequestDto requestForm) {
        return AdoptionRequest.builder()
                .id(requestForm.getId())
                .location(requestForm.getLocation())
                .reasonOrPurposeForAdoption(requestForm.getReasonOrPurposeForAdoption())
               .status(requestForm.getStatus())
                .parent(requestForm.getParent())
                .build();
    }
}
