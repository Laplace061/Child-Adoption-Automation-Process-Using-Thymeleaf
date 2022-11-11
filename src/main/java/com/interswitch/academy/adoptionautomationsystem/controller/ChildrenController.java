package com.interswitch.academy.adoptionautomationsystem.controller;

import com.interswitch.academy.adoptionautomationsystem.dto.ChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.service.ChildrenService;
import com.interswitch.academy.adoptionautomationsystem.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
}
