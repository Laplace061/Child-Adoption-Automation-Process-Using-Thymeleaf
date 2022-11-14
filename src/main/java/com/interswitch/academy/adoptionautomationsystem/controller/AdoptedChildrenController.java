package com.interswitch.academy.adoptionautomationsystem.controller;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptedChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.dto.AdoptiveParentDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptedChildren;
import com.interswitch.academy.adoptionautomationsystem.service.AdoptedChildrenService;
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

    // handler method to handle delete Adopted Child
    @GetMapping("/admin/adopted/{childId}/delete")
    public String deleteAdoptedChild(@PathVariable("childId") String childId){
        adoptedChildrenService.deleteChild(childId);
        return "redirect:/admin/adopted-children";
    }

    // handler method to handle view Adopted Child
    @GetMapping("/admin/adopted/{childId}/view")
    public String viewAdoptedChildren(@PathVariable("childId") String childId,
                                     Model model){
        AdoptedChildrenDto childDto = adoptedChildrenService.findAdoptedChildById(childId);
        model.addAttribute("child", childDto);
        return "admin/view_adoptedchild";

    }
}
