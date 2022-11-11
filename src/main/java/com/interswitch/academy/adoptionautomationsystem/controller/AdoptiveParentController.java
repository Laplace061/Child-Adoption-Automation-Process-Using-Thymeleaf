package com.interswitch.academy.adoptionautomationsystem.controller;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptiveParentDto;
import com.interswitch.academy.adoptionautomationsystem.service.AdoptiveParentService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AdoptiveParentController {

    private AdoptiveParentService parentService;

    public AdoptiveParentController(AdoptiveParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping("/admin/parents")
    public String getAllParents(Model model){
        List<AdoptiveParentDto> parents = parentService.findAllRequest();
        model.addAttribute("allParents", parents);
        return "/admin/parents";  // return a view
    }

    @GetMapping("admin/parents/newparent")
    public String newParentForm(Model model){

        AdoptiveParentDto parentDto = new AdoptiveParentDto();
        model.addAttribute("create_parent", parentDto);
        return "admin/create-parent";
    }

    @PostMapping("admin/parents")
        public String createParent(@Valid @ModelAttribute("create_parent") AdoptiveParentDto parentDto, BindingResult result, Model model){

        if (result.hasErrors()){
            model.addAttribute("create_parent", parentDto);
            return "admin/create-parent";
        }
            parentService.createParent(parentDto);
        return "redirect:/admin/parents";

    }

    // Method to edit post
    @GetMapping("/admin/parents/{parentId}/edit")
    public String editParentForm(@PathVariable("parentId") String parentId, Model model){
            AdoptiveParentDto parentDto = parentService.findParentById(parentId);
            model.addAttribute("edit_parent", parentDto);
            return "admin/edit-parent";
    }

    // Method to delete post by ID
    @GetMapping("/admin/parents/{parentId}/delete")
    public String deleteParent(@PathVariable("parentId") String parentId){

        parentService.deleteParentById(parentId);
        return "redirect:/admin/parents";
    }
}
