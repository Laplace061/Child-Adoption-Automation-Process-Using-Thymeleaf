package com.interswitch.academy.adoptionautomationsystem.service.serviceImpl;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptedChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.dto.ChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptedChildren;
import com.interswitch.academy.adoptionautomationsystem.entities.Children;
import com.interswitch.academy.adoptionautomationsystem.mapper.AdoptedChildrenMapper;
import com.interswitch.academy.adoptionautomationsystem.mapper.ChildrenMapper;
import com.interswitch.academy.adoptionautomationsystem.repository.AdoptedChildrenRepository;
import com.interswitch.academy.adoptionautomationsystem.service.AdoptedChildrenService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdoptedChildrenServiceImpl implements AdoptedChildrenService {

    private AdoptedChildrenRepository adoptedChildrenRepository;

    public AdoptedChildrenServiceImpl(AdoptedChildrenRepository adoptedChildrenRepository) {
        this.adoptedChildrenRepository = adoptedChildrenRepository;
    }

    @Override
    public List<AdoptedChildrenDto> findAllAdoptedChildren() {
        List<AdoptedChildren> adoptedChildren = adoptedChildrenRepository.findAll();
        return adoptedChildren.stream().map(AdoptedChildrenMapper::mapToAdoptedChildrenDto)
                .collect(Collectors.toList());
    }
}
