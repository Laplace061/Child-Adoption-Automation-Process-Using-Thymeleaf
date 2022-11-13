package com.interswitch.academy.adoptionautomationsystem.service.serviceImpl;

import com.interswitch.academy.adoptionautomationsystem.dto.GuardianAdLitemDto;
import com.interswitch.academy.adoptionautomationsystem.entities.Children;
import com.interswitch.academy.adoptionautomationsystem.entities.GuardianAdLitem;
import com.interswitch.academy.adoptionautomationsystem.mapper.ChildrenMapper;
import com.interswitch.academy.adoptionautomationsystem.mapper.GuardianAdLitemMapper;
import com.interswitch.academy.adoptionautomationsystem.repository.GuardianAdLitemRepository;
import com.interswitch.academy.adoptionautomationsystem.service.GuardianAdLitemService;
import com.interswitch.academy.adoptionautomationsystem.util.IdUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuardianAdLitemServiceImpl implements GuardianAdLitemService {

    private IdUtil idUtil;
    private GuardianAdLitemRepository guardianRepository;

    public GuardianAdLitemServiceImpl(IdUtil idUtil, GuardianAdLitemRepository guardianRepository) {
        this.idUtil = idUtil;
        this.guardianRepository = guardianRepository;
    }

    @Override
    public List<GuardianAdLitemDto> findAllGuardians() {
        List<GuardianAdLitem> guardians = guardianRepository.findAll();
        return guardians.stream().map(GuardianAdLitemMapper::mapToGuardianAdLitemDto)
                .collect(Collectors.toList());
    }

    @Override
    public GuardianAdLitem addStaff(GuardianAdLitemDto guardianAdLitemDto) {

        String staffId = idUtil.generateId(); // UUID.randomUUID().toString() was moved to the ChildIdUtil class
        guardianAdLitemDto.setId(staffId);
        GuardianAdLitem staff= GuardianAdLitemMapper.mapToGuardianAdLitem(guardianAdLitemDto);
        guardianRepository.save(staff);
        return staff;
    }

    @Override
    public GuardianAdLitemDto findGuardianById(String guardianId) {
        GuardianAdLitem guardian = guardianRepository.findById(guardianId).get();
        return GuardianAdLitemMapper.mapToGuardianAdLitemDto(guardian);
    }

    @Override
    public void updateGuardian(GuardianAdLitemDto guardianDto) {
        GuardianAdLitem guardian = GuardianAdLitemMapper.mapToGuardianAdLitem(guardianDto);
        guardianRepository.save(guardian);
    }

    @Override
    public void deleteGuardian(String guardianId) {
        guardianRepository.deleteById(guardianId);
    }
}
