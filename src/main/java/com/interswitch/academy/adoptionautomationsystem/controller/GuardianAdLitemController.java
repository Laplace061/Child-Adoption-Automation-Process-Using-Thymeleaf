package com.interswitch.academy.adoptionautomationsystem.controller;

import com.interswitch.academy.adoptionautomationsystem.dto.ChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.dto.GuardianAdLitemDto;
import com.interswitch.academy.adoptionautomationsystem.entities.GuardianAdLitem;
import com.interswitch.academy.adoptionautomationsystem.service.GuardianAdLitemService;
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

    // handler method to handle edit post request
    @GetMapping("/admin/guardians/{guardianId}/edit")
    public String editGuardianForm(@PathVariable("guardianId") String guardianId,
                               Model model){

        GuardianAdLitemDto guardianDto = guardianService.findGuardianById(guardianId);
        model.addAttribute("guardian", guardianDto);
        return "admin/edit_guardian";
    }

    // handler method to handle edit post form submit request
    @PostMapping("/admin/guardians/{guardianId}")
    public String updateGuardian(@PathVariable("guardianId") String guardianId,
                             @Valid @ModelAttribute("guardian") GuardianAdLitemDto guardian,
                             BindingResult result,
                             Model model){
        if(result.hasErrors()){
            model.addAttribute("guardian", guardian);
            return "admin/edit_guardian";
        }

        guardian.setId(guardianId);
       guardianService.updateGuardian(guardian);
        return "redirect:/admin/guardians";
    }
}
