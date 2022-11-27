package com.interswitch.academy.adoptionautomationsystem.controller;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptiveParentDto;
import com.interswitch.academy.adoptionautomationsystem.dto.ChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.entities.Children;
import com.interswitch.academy.adoptionautomationsystem.repository.ChildrenRepository;
import com.interswitch.academy.adoptionautomationsystem.service.AdoptiveParentService;
import com.interswitch.academy.adoptionautomationsystem.service.ChildrenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class AdoptiveParentController {

    private ChildrenService childrenService;
    private AdoptiveParentService parentService;

    public AdoptiveParentController(ChildrenService childrenService, AdoptiveParentService parentService) {
        this.childrenService = childrenService;
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

    // handler method to handle edit post request
    @GetMapping("/admin/parents/{parentId}/edit")
    public String editParentForm(@PathVariable("parentId") String parentId,
                               Model model){

        AdoptiveParentDto parentDto = parentService.findParentById(parentId);
        model.addAttribute("parent", parentDto);
        return "admin/edit-parent";
    }

    // handler method to handle edit post form submit request
    @PostMapping("/admin/parents/{parentId}")
    public String updateParent(@PathVariable("parentId") String parentId,
                             @Valid @ModelAttribute("parent") AdoptiveParentDto parent,
                             BindingResult result,
                             Model model){
        if(result.hasErrors()){
            model.addAttribute("parent", parent);
            return "admin/edit-parent";
        }

        parent.setId(parentId);
        parentService.updateParent(parent);
        return "redirect:/admin/parents";
    }

    // handler method to handle delete Adoptive Parent
    @GetMapping("/admin/parents/{parentId}/delete")
    public String deletePost(@PathVariable("parentId") String parentId){
        parentService.deleteParent(parentId);
        return "redirect:/admin/parents";
    }

    // handler method to handle view Parent
    @GetMapping("/admin/parents/{parentId}/view")
    public String viewAdoptiveParent(@PathVariable("parentId") String parentId,
                               Model model){
        AdoptiveParentDto parentDto = parentService.findParentById(parentId);
        model.addAttribute("parent", parentDto);
        return "admin/view_parent";

    }

    // handler method to handle search Parent
    // localhost:${Port:0}/admin/parents/search?text=java
    @GetMapping("/admin/parents/search")
    public String searchParents(@RequestParam(value = "text") String text,
                              Model model){
        List<AdoptiveParentDto> parent = parentService.searchParent(text);
        model.addAttribute("allParents", parent);
        return "admin/parents";
    }

    @GetMapping("/admin/parents/{parentId}/viewchild")
    public String viewChildInfo(@PathVariable("parentId") String parentId,
                               Model model){
        ChildrenDto children = childrenService.findChildByParentId(parentId);
        model.addAttribute("children", children);
        return "admin/view_child";

    }
}
