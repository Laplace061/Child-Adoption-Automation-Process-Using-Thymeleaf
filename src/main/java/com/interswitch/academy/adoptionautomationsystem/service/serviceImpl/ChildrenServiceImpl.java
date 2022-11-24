package com.interswitch.academy.adoptionautomationsystem.service.serviceImpl;

import com.interswitch.academy.adoptionautomationsystem.dto.ChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.Children;
import com.interswitch.academy.adoptionautomationsystem.entities.User;
import com.interswitch.academy.adoptionautomationsystem.mapper.ChildrenMapper;
import com.interswitch.academy.adoptionautomationsystem.repository.AdoptiveParentRepository;
import com.interswitch.academy.adoptionautomationsystem.repository.ChildrenRepository;
import com.interswitch.academy.adoptionautomationsystem.repository.UserRepository;
import com.interswitch.academy.adoptionautomationsystem.service.ChildrenService;
import com.interswitch.academy.adoptionautomationsystem.util.IdUtil;
import com.interswitch.academy.adoptionautomationsystem.util.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildrenServiceImpl implements ChildrenService {

    private IdUtil idUtil;
    private ChildrenRepository childrenRepository;

    private AdoptiveParentRepository parentRepository;

    public ChildrenServiceImpl(IdUtil idUtil, ChildrenRepository childrenRepository, UserRepository userRepository) {
        this.idUtil = idUtil;
        this.childrenRepository = childrenRepository;
        this.parentRepository = parentRepository;
    }

    @Override
    public List<ChildrenDto> findAllChildren() {
        List<Children> children = childrenRepository.findAll();
        return children.stream().map((child) -> ChildrenMapper.mapToChildrenDto(child))
                .collect(Collectors.toList());
    }

    @Override
    public Children addChild(ChildrenDto childrenDto) {

        String name = SecurityUtils.getCurrentUser().getName();
        AdoptiveParent parent = parentRepository.findAdoptiveParentByNameIgnoreCase(name);

        String childId = idUtil.generateId();
        childrenDto.setId(childId);
        Children child= ChildrenMapper.mapToChildren(childrenDto);
        child.setParent(parent);
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