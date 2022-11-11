package com.interswitch.academy.adoptionautomationsystem.controller;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptedChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.dto.AdoptiveParentDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptedChildren;
import com.interswitch.academy.adoptionautomationsystem.service.AdoptedChildrenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdoptedChildrenController {

    private AdoptedChildrenService adoptedChildrenService;

    public AdoptedChildrenController(AdoptedChildrenService adoptedChildrenService) {
        this.adoptedChildrenService = adoptedChildrenService;
    }

    @GetMapping("/admin/adopted")
    public String getAllAdoptedChildren(Model model){
        List<AdoptedChildrenDto> adoptedChildren = adoptedChildrenService.findAllAdoptedChildren();
        model.addAttribute("allAdoptedChildren", adoptedChildren);
        return "/admin/adopted-children";  // return a view
    }
}
