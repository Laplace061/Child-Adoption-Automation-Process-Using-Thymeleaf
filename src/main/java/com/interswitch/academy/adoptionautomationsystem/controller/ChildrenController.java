package com.interswitch.academy.adoptionautomationsystem.controller;

import com.interswitch.academy.adoptionautomationsystem.dto.ChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.dto.TrackingDto;
import com.interswitch.academy.adoptionautomationsystem.service.ChildrenService;
import com.interswitch.academy.adoptionautomationsystem.util.IdUtil;
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
@Slf4j
@Controller
public class ChildrenController {

    private IdUtil childIdUtil;
    private ChildrenService childrenService;

    public ChildrenController(IdUtil idUtil, ChildrenService childrenService) {
        this.childIdUtil = idUtil;
        this.childrenService = childrenService;
    }

    @GetMapping("/admin/children")
    public String getAllchildren(Model model) {
        List<ChildrenDto> children = childrenService.findAllChildren();
        model.addAttribute("allChildren", children);
        return "/admin/children";  // return a view
    }

    @GetMapping("admin/children/newchild")
    public String newChildForm(Model model) {

        ChildrenDto childDto = new ChildrenDto();
        model.addAttribute("create_child", childDto);
        return "admin/create-child";
    }

    @PostMapping("admin/children")
    public String createChild(@ModelAttribute ChildrenDto childrenDto) {

        log.info("Dto is:  {}", childrenDto);

        childrenService.addChild(childrenDto);
        return "redirect:/admin/children";

    }

    // handler method to handle edit post request
    @GetMapping("/admin/children/{childId}/edit")
    public String editChildForm(@PathVariable("childId") String childId,
                               Model model){

        ChildrenDto childDto = childrenService.findChildById(childId);
        model.addAttribute("child", childDto);
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
            return "admin/edit_child";
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
    public String viewChildren(@PathVariable("childId") String childId,
                               Model model){
        ChildrenDto childrenDto = childrenService.findChildById(childId);
        model.addAttribute("children", childrenDto);
        return "admin/view_children";

    }
}
