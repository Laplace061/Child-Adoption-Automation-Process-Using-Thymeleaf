package com.interswitch.academy.adoptionautomationsystem.controller;

import com.interswitch.academy.adoptionautomationsystem.dto.ChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.GuardianAdLitem;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.AdoptionStatus;
import com.interswitch.academy.adoptionautomationsystem.repository.AdoptiveParentRepository;
import com.interswitch.academy.adoptionautomationsystem.repository.GuardianAdLitemRepository;
import com.interswitch.academy.adoptionautomationsystem.service.ChildrenService;
import com.interswitch.academy.adoptionautomationsystem.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class ChildrenController {
    private IdUtil childIdUtil;
    private ChildrenService childrenService;
    private AdoptiveParentRepository parentRepository;
    private GuardianAdLitemRepository guardianAdLitemRepository;


    public ChildrenController(IdUtil childIdUtil, ChildrenService childrenService,
                              AdoptiveParentRepository parentRepository, GuardianAdLitemRepository guardianAdLitemRepository) {
        this.childIdUtil = childIdUtil;
        this.childrenService = childrenService;
        this.parentRepository = parentRepository;
        this.guardianAdLitemRepository = guardianAdLitemRepository;
    }

    @GetMapping("/admin/children")
    public String getAllchildren(Model model) {
        List<ChildrenDto> children = childrenService.findAllChildren();
        model.addAttribute("allChildren", children);
        return "/admin/children";  // return a view
    }

    @GetMapping("admin/children/newchild")
    public String newChildForm(Model model) {

        List<GuardianAdLitem> guardians = guardianAdLitemRepository.findAll();
        List<AdoptiveParent> parents = parentRepository.findAll();

        ChildrenDto childDto = new ChildrenDto();
        model.addAttribute("create_child", childDto);
        model.addAttribute("listParents", parents);
        model.addAttribute("listGuardians", guardians);
        return "admin/create-child";
    }

    @PostMapping("admin/children")
    public String createChild(@Valid @ModelAttribute("create_child") ChildrenDto childDto, BindingResult result, Model model) {

        if(result.hasErrors()){
            model.addAttribute("create_child", childDto);
            return "admin/create-child";
        }
        childDto.setStatus(AdoptionStatus.PROBATION);
        log.info("Dto is:  {}", childDto);

        childrenService.addChild(childDto);
        return "redirect:/admin/children";

    }

    // handler method to handle edit post request
    @GetMapping("/admin/children/{childId}/edit")
    public String editChildForm(@PathVariable("childId") String childId,
                               Model model){

        List<GuardianAdLitem> guardians = guardianAdLitemRepository.findAll();
        List<AdoptiveParent> parents = parentRepository.findAll();

        ChildrenDto childDto = childrenService.findChildById(childId);
        model.addAttribute("child", childDto);
        model.addAttribute("listParents", parents);
        model.addAttribute("listGuardians", guardians);

        return "admin/edit_child";
    }

    // handler method to handle edit post form submit request
    @PostMapping("/admin/children/{childId}")
    public String updateChild(@PathVariable("childId") String childId,
                             @Valid @ModelAttribute("child") ChildrenDto child,
                             BindingResult result,
                             Model model){
        if(result.hasErrors()){
            model.addAttribute("child", child);
            return "/admin/children";
        }

        child.setId(childId);
        childrenService.updateChild(child);
        return "redirect:/admin/children";
    }

    // handler method to handle delete Child
    @GetMapping("/admin/children/{childId}/delete")
    public String deleteChild(@PathVariable("childId") String childId){
        childrenService.deleteChild(childId);
        return "redirect:/admin/children";
    }

    // handler method to handle view Children
    @GetMapping("/admin/children/{childId}/view")
    public String viewChildInfo(@PathVariable("childId") String childId,
                               Model model){
        ChildrenDto childrenDto = childrenService.findChildById(childId);
        model.addAttribute("children", childrenDto);
        return "admin/view_child";

    }

    // handler method to handle search Child
    // localhost:${Port:0}/admin/children/search?text=java
    @GetMapping("/admin/children/search")
    public String searchChildren(@RequestParam(value = "text") String text,
                              Model model){
        List<ChildrenDto> child = childrenService.searchChildren(text);
        System.out.println(child);
        model.addAttribute("allChildren", child);
        return "admin/children";
    }
}
