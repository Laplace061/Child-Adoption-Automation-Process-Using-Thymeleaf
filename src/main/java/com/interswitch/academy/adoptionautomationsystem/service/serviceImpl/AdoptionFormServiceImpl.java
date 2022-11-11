package com.interswitch.academy.adoptionautomationsystem.service.serviceImpl;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptionFormDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptionForm;
import com.interswitch.academy.adoptionautomationsystem.mapper.AdoptionFormMapper;
import com.interswitch.academy.adoptionautomationsystem.repository.AdoptionFormRepository;
import com.interswitch.academy.adoptionautomationsystem.service.AdoptionFormService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdoptionFormServiceImpl implements AdoptionFormService {

    private AdoptionFormRepository adoptionFormRepository;

    public AdoptionFormServiceImpl(AdoptionFormRepository adoptionFormRepository) {
        this.adoptionFormRepository = adoptionFormRepository;
    }

    @Override
    public List<AdoptionFormDto> findAllAdoptionForm() {

        List<AdoptionForm> forms = adoptionFormRepository.findAll();
        return forms.stream().map((form) -> AdoptionFormMapper.mapToAdoptionFormDto(form))
                .collect(Collectors.toList());
    }
}
