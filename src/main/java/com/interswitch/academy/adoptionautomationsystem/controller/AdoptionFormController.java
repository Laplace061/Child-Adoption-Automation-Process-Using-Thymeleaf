package com.interswitch.academy.adoptionautomationsystem.controller;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptionFormDto;
import com.interswitch.academy.adoptionautomationsystem.service.AdoptionFormService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdoptionFormController {

private AdoptionFormService adoptionFormService;

    public AdoptionFormController(AdoptionFormService adoptionFormService) {
        this.adoptionFormService = adoptionFormService;
    }

    @GetMapping("/admin/adoptionforms")
    public String getAllAdoptionForms(Model model){

        List<AdoptionFormDto> forms = adoptionFormService.findAllAdoptionForm();
        model.addAttribute("allAdoptionForms", forms);
        return "/admin/adoption-forms";
    }
}
