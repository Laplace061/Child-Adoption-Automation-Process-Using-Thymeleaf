package com.interswitch.academy.adoptionautomationsystem.service.serviceImpl;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptiveParentDto;
import com.interswitch.academy.adoptionautomationsystem.dto.RequestDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptionRequest;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.mapper.AdoptiveParentMapper;
import com.interswitch.academy.adoptionautomationsystem.mapper.RequestMapper;
import com.interswitch.academy.adoptionautomationsystem.repository.AdoptionRequestRepository;
import com.interswitch.academy.adoptionautomationsystem.repository.AdoptiveParentRepository;
import com.interswitch.academy.adoptionautomationsystem.service.AdoptionRequestService;
import com.interswitch.academy.adoptionautomationsystem.util.IdUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdoptionRequestServiceImpl implements AdoptionRequestService {

    private IdUtil idUtil;

    private AdoptiveParentRepository parentRepository;
    private AdoptionRequestRepository requestRepository;

    public AdoptionRequestServiceImpl(IdUtil idUtil, AdoptiveParentRepository parentRepository, AdoptionRequestRepository requestRepository) {
        this.idUtil = idUtil;
        this.parentRepository = parentRepository;
        this.requestRepository = requestRepository;
    }

    @Override
    public List<RequestDto> findAllRequest() {
        List<AdoptionRequest> requests = requestRepository.findAll();
        return requests.stream().map((request) -> RequestMapper.mapToRequestDto(request))
                .collect(Collectors.toList());

        // or

        /* return requests.stream().map(RequestMapper::mapToRequestDto)
         *       .collect(Collectors.toList());
         */
    }

    @Override
    public AdoptionRequest createRequest(RequestDto requestDto) {
        String requestId = idUtil.generateId(); // UUID.randomUUID().toString() was moved to the ChildIdUtil class
        requestDto.setId(requestId);
       AdoptionRequest request = RequestMapper.mapToRequest(requestDto);
        requestRepository.save(request);
        return request;
    }

//  @Override
//   public String getParentName() {
//        return parentRepository.findById().getName();
//
//   }
}
