package com.interswitch.academy.adoptionautomationsystem.controller;

import com.interswitch.academy.adoptionautomationsystem.dto.ChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.dto.GuardianAdLitemDto;
import com.interswitch.academy.adoptionautomationsystem.entities.GuardianAdLitem;
import com.interswitch.academy.adoptionautomationsystem.service.GuardianAdLitemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class GuardianAdLitemController {

    private GuardianAdLitemService guardianService;

    public GuardianAdLitemController(GuardianAdLitemService guardianService) {
        this.guardianService = guardianService;
    }

    @GetMapping("/admin/guardians")
    public String getAllGuardianAdLitem(Model model){

        List<GuardianAdLitemDto> guardians = guardianService.findAllGuardians();
        model.addAttribute("allGuardians", guardians);
        return "admin/guardians";
    }

    @GetMapping("admin/guardians/newguardian")
    public String newStaffForm(Model model) {

        GuardianAdLitemDto staffDto = new GuardianAdLitemDto();
        model.addAttribute("create_guardian", staffDto);
        return "admin/create-guardian";
    }

    @PostMapping("admin/guardians")
    public String createStaff(@ModelAttribute GuardianAdLitemDto guardianAdLitemDto) {

        log.info("Dto is:  {}", guardianAdLitemDto);

        guardianService.addStaff(guardianAdLitemDto);
        return "redirect:/admin/guardians";

    }
}
