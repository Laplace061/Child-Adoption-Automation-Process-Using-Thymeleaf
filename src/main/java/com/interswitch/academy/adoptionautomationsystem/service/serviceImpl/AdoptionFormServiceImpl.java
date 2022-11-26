package com.interswitch.academy.adoptionautomationsystem.service.serviceImpl;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptionFormDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptionForm;
import com.interswitch.academy.adoptionautomationsystem.mapper.AdoptionFormMapper;
import com.interswitch.academy.adoptionautomationsystem.repository.AdoptionFormRepository;
import com.interswitch.academy.adoptionautomationsystem.service.AdoptionFormService;
import com.interswitch.academy.adoptionautomationsystem.util.IdUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdoptionFormServiceImpl implements AdoptionFormService {

    private IdUtil idUtil;
    private AdoptionFormRepository adoptionFormRepository;

    public AdoptionFormServiceImpl(IdUtil idUtil, AdoptionFormRepository adoptionFormRepository) {
        this.idUtil = idUtil;
        this.adoptionFormRepository = adoptionFormRepository;
    }

    @Override
    public List<AdoptionFormDto> findAllAdoptionForm() {

        List<AdoptionForm> forms = adoptionFormRepository.findAll();
        return forms.stream().map((form) -> AdoptionFormMapper.mapToAdoptionFormDto(form))
                .collect(Collectors.toList());
    }

    @Override
    public AdoptionForm createForm(AdoptionFormDto adoptionFormDto) {
        String formId = idUtil.generateId();
        adoptionFormDto.setId(formId);
        AdoptionForm form = AdoptionFormMapper.mapToAdoptionForm(adoptionFormDto);
        adoptionFormRepository.save(form);
        return form;
    }

    @Override
    public AdoptionFormDto findFormById(String formId) {
        AdoptionForm form = adoptionFormRepository.findById(formId).get();
        return AdoptionFormMapper.mapToAdoptionFormDto(form);
    }

    @Override
    public void updateAdoptionForm(AdoptionFormDto formDto) {
        AdoptionForm form = AdoptionFormMapper.mapToAdoptionForm(formDto);
        adoptionFormRepository.save(form);
    }

    @Override
    public void deleteAdoptionForm(String formId) {
        adoptionFormRepository.deleteById(formId);
    }

    @Override
    public List<AdoptionFormDto> searchForm(String text) {
        List<AdoptionForm> form = adoptionFormRepository.searchAdoptionForm(text);
        return form.stream()
                .map(AdoptionFormMapper::mapToAdoptionFormDto)
                .collect(Collectors.toList());
    }
}
