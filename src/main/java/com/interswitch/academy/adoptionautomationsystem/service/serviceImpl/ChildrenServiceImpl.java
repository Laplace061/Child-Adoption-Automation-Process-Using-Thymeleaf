package com.interswitch.academy.adoptionautomationsystem.service.serviceImpl;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptiveParentDto;
import com.interswitch.academy.adoptionautomationsystem.dto.ChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.Children;
import com.interswitch.academy.adoptionautomationsystem.entities.GuardianAdLitem;
import com.interswitch.academy.adoptionautomationsystem.entities.User;
import com.interswitch.academy.adoptionautomationsystem.mapper.AdoptiveParentMapper;
import com.interswitch.academy.adoptionautomationsystem.mapper.ChildrenMapper;
import com.interswitch.academy.adoptionautomationsystem.mapper.GuardianAdLitemMapper;
import com.interswitch.academy.adoptionautomationsystem.repository.AdoptiveParentRepository;
import com.interswitch.academy.adoptionautomationsystem.repository.ChildrenRepository;
import com.interswitch.academy.adoptionautomationsystem.repository.UserRepository;
import com.interswitch.academy.adoptionautomationsystem.service.ChildrenService;
import com.interswitch.academy.adoptionautomationsystem.util.GetChildAgeUtil;
import com.interswitch.academy.adoptionautomationsystem.util.IdUtil;
import com.interswitch.academy.adoptionautomationsystem.util.SecurityUtils;
import javassist.NotFoundException;
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
    private UserRepository userRepository;

    public ChildrenServiceImpl(IdUtil idUtil, GetChildAgeUtil childAgeUtil, ChildrenRepository childrenRepository,
                               AdoptiveParentRepository parentRepository, UserRepository userRepository) {
        this.idUtil = idUtil;
        this.childAgeUtil = childAgeUtil;
        this.childrenRepository = childrenRepository;
        this.parentRepository = parentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ChildrenDto> findAllChildren() {
        List<Children> children = childrenRepository.findAll();
        return children.stream().map((child) -> ChildrenMapper.mapToChildrenDto(child))
                .collect(Collectors.toList());
    }

    @Override
    public Children addChild(ChildrenDto childrenDto) {
        String email = SecurityUtils.getCurrentUser().getUsername();
        User user = userRepository.findByEmail(email);
        String childId = idUtil.generateId();
        System.out.println("child : " + childId);
        childrenDto.setId(childId);

        Children child = ChildrenMapper.mapToChildren(childrenDto);
        child.setCreatedBy(user);
        log.info("Child is:  {}", child);


        Optional<Children> optionalParent = childrenRepository.findChildrenByParentId(child.getParent().getId());
        Optional<Children> optionalChild = childrenRepository.findById(child.getId());

        if (optionalParent.isPresent() || optionalChild.isPresent()) {
            throw new RuntimeException("Child or Parent already exist");

        } else if ( // Conditions for Single Parent
                ( child.getParent().getMaritalStatus().getDisplayValue().equalsIgnoreCase("Single")
                        && (child.getParent().getAge() < 35)
                        && (child.getParent().getAge() - childAgeUtil.getChildAge(child.getDob()) < 21
                        && !(child.getParent().getGender().getDisplayValue().toLowerCase().equalsIgnoreCase( child.getGender().getDisplayValue().toLowerCase()))
                        && !(child.getParent().getNationality().equalsIgnoreCase("Nigerian"))))

                        //    Conditions for Married Parent
                        &&

                        ( (child.getParent().getMaritalStatus().getDisplayValue().equalsIgnoreCase("Married")
                                && (child.getParent().getAge() < 25)
                                && (child.getParent().getAge() - childAgeUtil.getChildAge(child.getDob()) < 21)
                                && !(child.getParent().getNationality().equalsIgnoreCase("Nigerian"))))){

            throw new RuntimeException(child.getParent().getName() + " and " + child.getFirstName() + " " + child.getLastName() + " adoption process cannot be completed. Please Kindly get a another child ");

        } else {

            childrenRepository.save(child);
            return child;
        }
    }

    @Override
    public ChildrenDto findChildById(String childId){
        Children child = childrenRepository.findById(childId).get();
        return ChildrenMapper.mapToChildrenDto(child);
    }

    @Override
    public void updateChild(ChildrenDto childrenDto) {
        String email = SecurityUtils.getCurrentUser().getUsername();
        User user = userRepository.findByEmail(email);
        Children child = ChildrenMapper.mapToChildren(childrenDto);
        child.setUpdatedBy(user);
        childrenRepository.save(child);
    }

    @Override
    public void deleteChild(String childId) {
        childrenRepository.deleteById(childId);

//        @Override
//        public void deleteBook(Long id) {
//            var book = bookRepository.findById(id)
//                    .orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", id)));
//
//            bookRepository.deleteById(book.getId());
//        }
    }

    @Override
    public List<ChildrenDto> searchChildren(String text) {
        List<Children> child = childrenRepository.searchChildren(text);
        return child.stream()
                .map(ChildrenMapper::mapToChildrenDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ChildrenDto> findChildByGuardianId(String guardianId) {

        List<Children> children = childrenRepository.findChildrenByGuardianId(guardianId);
        return children.stream().map(ChildrenMapper::mapToChildrenDto)
                .collect(Collectors.toList());
    }

    @Override
    public ChildrenDto findChildByParentId(String parentId) {

        Children child = childrenRepository.findChildByParentId(parentId);

        return ChildrenMapper.mapToChildrenDto(child);
    }


}