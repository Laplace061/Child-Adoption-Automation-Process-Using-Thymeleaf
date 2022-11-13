package com.interswitch.academy.adoptionautomationsystem.controller;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptionFormDto;
import com.interswitch.academy.adoptionautomationsystem.dto.AdoptiveParentDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptionForm;
import com.interswitch.academy.adoptionautomationsystem.service.AdoptionFormService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
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

    @GetMapping("admin/adoptionforms/newadoptionform")
    public String newAdoptionForm(Model model){

        AdoptionFormDto formDto = new AdoptionFormDto();
        model.addAttribute("create_adoptionform", formDto);
        return "admin/create-adoptionform";
    }

    @PostMapping("admin/adoptionforms")
    public String createAdoptionForm(@Valid @ModelAttribute("create_adoptionform") AdoptionFormDto adoptionFormDto, BindingResult result, Model model){

        if (result.hasErrors()){
            model.addAttribute("create_adoptionform", adoptionFormDto);
            return "admin/create-adoptionform";
        }
        adoptionFormService.createForm(adoptionFormDto);
        return "redirect:/admin/adoptionforms";

    }

    // handler method to handle edit adoption form
    @GetMapping("/admin/adoptionforms/{formId}/edit")
    public String editAdoptionForm(@PathVariable("formId") String formId,
                               Model model){

        AdoptionFormDto formDto = adoptionFormService.findFormById(formId);
        model.addAttribute("form", formDto);
        return "admin/edit-adoptionform";
    }

    // handler method to handle edit post form submit request
    @PostMapping("/admin/adoptionforms/{formId}")
    public String updateAdoptionForm(@PathVariable("formId") String formId,
                             @Valid @ModelAttribute("form") AdoptionFormDto form,
                             BindingResult result,
                             Model model){
        if(result.hasErrors()){
            model.addAttribute("form", form);
            return "admin/edit-adoptionform";
        }

        form.setId(formId);
        adoptionFormService.updateAdoptionForm(form);
        return "redirect:/admin/adoptionforms";
    }
}
