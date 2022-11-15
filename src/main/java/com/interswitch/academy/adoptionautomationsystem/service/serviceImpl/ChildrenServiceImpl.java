package com.interswitch.academy.adoptionautomationsystem.service.serviceImpl;

import com.interswitch.academy.adoptionautomationsystem.dto.ChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.dto.TrackingDto;
import com.interswitch.academy.adoptionautomationsystem.entities.Children;
import com.interswitch.academy.adoptionautomationsystem.entities.Tracking;
import com.interswitch.academy.adoptionautomationsystem.mapper.ChildrenMapper;
import com.interswitch.academy.adoptionautomationsystem.mapper.TrackingMapper;
import com.interswitch.academy.adoptionautomationsystem.repository.ChildrenRepository;
import com.interswitch.academy.adoptionautomationsystem.service.ChildrenService;
import com.interswitch.academy.adoptionautomationsystem.util.IdUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildrenServiceImpl implements ChildrenService {

    private IdUtil idUtil;
    private ChildrenRepository childrenRepository;

    public ChildrenServiceImpl(IdUtil idUtil, ChildrenRepository childrenRepository) {
        this.idUtil = idUtil;
        this.childrenRepository = childrenRepository;
    }

    @Override
    public List<ChildrenDto> findAllChildren() {
        List<Children> children = childrenRepository.findAll();
        return children.stream().map((child) -> ChildrenMapper.mapToChildrenDto(child))
                .collect(Collectors.toList());
    }

    @Override
    public Children addChild(ChildrenDto childrenDto) {

        String childId = idUtil.generateId(); // UUID.randomUUID().toString() was moved to the ChildIdUtil class
        childrenDto.setId(childId);
        Children child= ChildrenMapper.mapToChildren(childrenDto);
        childrenRepository.save(child);
        return child;
    }

    @Override
    public ChildrenDto findChildById(String childId) {
        Children child = childrenRepository.findById(childId).get();
        return ChildrenMapper.mapToChildrenDto(child);
    }

    @Override
    public void updateChild(ChildrenDto childrenDto) {
        Children child = ChildrenMapper.mapToChildren(childrenDto);
        childrenRepository.save(child);
    }

    @Override
    public void deleteChild(String childId) {
        childrenRepository.deleteById(childId);
    }

    @Override
    public List<ChildrenDto> searchChildren(String text) {
        List<Children> child = childrenRepository.searchChildren(text);
        return child.stream()
                .map(ChildrenMapper::mapToChildrenDto)
                .collect(Collectors.toList());
    }
}