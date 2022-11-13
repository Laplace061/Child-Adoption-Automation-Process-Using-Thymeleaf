package com.interswitch.academy.adoptionautomationsystem.service.serviceImpl;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptiveParentDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.mapper.AdoptiveParentMapper;
import com.interswitch.academy.adoptionautomationsystem.repository.AdoptiveParentRepository;
import com.interswitch.academy.adoptionautomationsystem.service.AdoptiveParentService;
import com.interswitch.academy.adoptionautomationsystem.util.IdUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdoptiveParentServiceImpl implements AdoptiveParentService {

    private IdUtil idUtil;
    private AdoptiveParentRepository parentRepository;

    public AdoptiveParentServiceImpl(IdUtil idUtil, AdoptiveParentRepository parentRepository) {
        this.idUtil = idUtil;
        this.parentRepository = parentRepository;
    }

    @Override
    public List<AdoptiveParentDto> findAllRequest() {
        List<AdoptiveParent> parents = parentRepository.findAll();
        return parents.stream().map((parent) -> AdoptiveParentMapper.mapToAdoptiveParentDto(parent))
                .collect(Collectors.toList());

    }

    @Override
    public AdoptiveParent createParent(AdoptiveParentDto adoptiveParentDto) {
        String parentId = idUtil.generateId();
        adoptiveParentDto.setId(parentId);
        AdoptiveParent parent = AdoptiveParentMapper.mapToAdoptiveParent(adoptiveParentDto);
        parentRepository.save(parent);
        return parent;
    }

    @Override
    public AdoptiveParentDto findParentById(String parentId) {
        AdoptiveParent parent = parentRepository.findById(parentId).get();
        return AdoptiveParentMapper.mapToAdoptiveParentDto(parent);
    }

    @Override
    public void updateParent(AdoptiveParentDto parentDto) {
        AdoptiveParent parent = AdoptiveParentMapper.mapToAdoptiveParent(parentDto);
        parentRepository.save(parent);
    }

    @Override
    public void deleteParent(String parentId) {
        parentRepository.deleteById(parentId);
    }
}
