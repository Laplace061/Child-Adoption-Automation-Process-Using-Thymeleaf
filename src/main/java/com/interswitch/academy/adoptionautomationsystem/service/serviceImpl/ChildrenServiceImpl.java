package com.interswitch.academy.adoptionautomationsystem.service.serviceImpl;

import com.interswitch.academy.adoptionautomationsystem.dto.ChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.Children;
import com.interswitch.academy.adoptionautomationsystem.mapper.ChildrenMapper;
import com.interswitch.academy.adoptionautomationsystem.repository.AdoptiveParentRepository;
import com.interswitch.academy.adoptionautomationsystem.repository.ChildrenRepository;
import com.interswitch.academy.adoptionautomationsystem.service.ChildrenService;
import com.interswitch.academy.adoptionautomationsystem.util.GetChildAgeUtil;
import com.interswitch.academy.adoptionautomationsystem.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ChildrenServiceImpl implements ChildrenService {

    private IdUtil idUtil;

    private GetChildAgeUtil childAgeUtil;
    private ChildrenRepository childrenRepository;

    private AdoptiveParentRepository parentRepository;

    public ChildrenServiceImpl(IdUtil idUtil, GetChildAgeUtil childAgeUtil, ChildrenRepository childrenRepository, AdoptiveParentRepository parentRepository) {
        this.idUtil = idUtil;
        this.childAgeUtil = childAgeUtil;
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

        String childId = idUtil.generateId();
        System.out.println("child : " + childId);
        childrenDto.setId(childId);

        Children child = ChildrenMapper.mapToChildren(childrenDto);
        log.info("Child is:  {}", child);

        // Boolean parent = parentRepository.existsById(child.getParent().getId());

//        Optional<Children> optional = childrenRepository.findById(child.getParent().getId());

        Optional<Children> optional = childrenRepository.findChildrenByParentExists(child.getParent().getId());

        if (optional.isPresent()) {
            throw new RuntimeException(" This parent already exist with id :: " + child.getParent().getId());

        } else if ( // Conditions for Single Parent
                !(child.getParent().getMaritalStatus().getDisplayValue().equalsIgnoreCase("Single")
                        && child.getParent().getAge() >= 35
                        && (child.getParent().getAge() - childAgeUtil.getChildAge(child.getDob()) >= 21)
                        && child.getParent().getGender().getDisplayValue().toLowerCase() == child.getGender().getDisplayValue().toLowerCase()
                        //          && child.getParent().getDocuments().stream().count() == 10
                        && child.getParent().getNationality().equalsIgnoreCase("Nigerian"))

                        //    Conditions for Married Parent
                        &&
                        !(child.getParent().getMaritalStatus().getDisplayValue().equalsIgnoreCase("Married")
                                && child.getParent().getAge() >= 25
                                && (child.getParent().getAge() - childAgeUtil.getChildAge(child.getDob()) >= 21)
                                && child.getParent().getGender().getDisplayValue().equalsIgnoreCase(child.getGender().getDisplayValue())
                                //  && child.getParent().getDocuments().stream().count() == 10
                                && child.getParent().getNationality().equalsIgnoreCase("Nigerian"))) {

            throw new RuntimeException(child.getParent().getName() + " and " + child.getFirstName() + " " + child.getLastName() + " adoption process cannot be completed. Please Kindly get a another child ");

        } else {

            childrenRepository.save(child);
            return child;
        }
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