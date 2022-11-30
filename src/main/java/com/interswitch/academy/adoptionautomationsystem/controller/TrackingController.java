package com.interswitch.academy.adoptionautomationsystem.controller;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptiveParentDto;
import com.interswitch.academy.adoptionautomationsystem.dto.TrackingDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.GuardianAdLitem;
import com.interswitch.academy.adoptionautomationsystem.repository.AdoptiveParentRepository;
import com.interswitch.academy.adoptionautomationsystem.repository.GuardianAdLitemRepository;
import com.interswitch.academy.adoptionautomationsystem.service.TrackingService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TrackingController {

    private static final Logger log = LoggerFactory.getLogger(TrackingController.class);

    private TrackingService trackingService;
    private AdoptiveParentRepository parentRepository;
    private GuardianAdLitemRepository guardianRepository;


    public TrackingController(TrackingService trackingService, AdoptiveParentRepository parentRepository, GuardianAdLitemRepository guardianRepository) {
        this.trackingService = trackingService;
        this.parentRepository = parentRepository;
        this.guardianRepository = guardianRepository;
    }

    @GetMapping("/admin/tracking")
    public String getAllTracking(Model model){
        List<TrackingDto> trackings = trackingService.findAllTracking();
        model.addAttribute("allTracking", trackings);
        return "/admin/tracking";  // return a view
    }

    @GetMapping("admin/tracking/newtracking")
    public String newTrackingForm(Model model) {

        List<AdoptiveParent> parents = parentRepository.findAll();
        List<GuardianAdLitem> guardians = guardianRepository.findAll();
        TrackingDto trackingDto = new TrackingDto();
        model.addAttribute("create_tracking", trackingDto);
        model.addAttribute("listParents", parents);
        model.addAttribute("listGuardians", guardians);
        return "admin/create-tracking";
    }

    @PostMapping("admin/tracking")
    public String createTracking(@Valid @ModelAttribute("create_tracking") TrackingDto trackingDto, BindingResult result, Model model) {

        log.info("Dto is:  {}", trackingDto);

        if(result.hasErrors()){
            model.addAttribute("create_tracking", trackingDto);
            return "admin/create-tracking";
        }
        trackingService.addTracking(trackingDto);
        return "redirect:/admin/tracking";

    }

    // handler method to handle edit post request
    @GetMapping("/admin/tracking/{trackingId}/edit")
    public String editTrackingForm(@PathVariable("trackingId") String trackingId,
                               Model model){

       TrackingDto trackingDto = trackingService.findTrackingById(trackingId);
        model.addAttribute("tracking", trackingDto);
        return "admin/edit_tracking";
    }

    // handler method to handle edit post form submit request
    @PostMapping("/admin/tracking/{trackingId}")
    public String updateTracking(@PathVariable("trackingId") String trackingId,
                             @Valid @ModelAttribute("tracking") TrackingDto tracking,
                             BindingResult result,
                             Model model){
        if(result.hasErrors()){
            model.addAttribute("tracking", tracking);
            return "admin/edit_tracking";
        }

        tracking.setId(trackingId);
        trackingService.updateTracking(tracking);
        return "redirect:/admin/tracking";
    }

    // handler method to handle delete tracking
    @GetMapping("/admin/tracking/{trackingId}/delete")
    public String deleteTracking(@PathVariable("trackingId") String trackingId){
        trackingService.deleteTracking(trackingId);
        return "redirect:/admin/tracking";
    }

    // handler method to handle view tracking
    @GetMapping("/admin/tracking/{trackingId}/view")
    public String viewTracking(@PathVariable("trackingId") String trackingId,
                           Model model){
        TrackingDto trackingDto = trackingService.findTrackingById(trackingId);
        model.addAttribute("tracking", trackingDto);
        return "admin/view_tracking";

    }

    // handler method to handle search Tracking
    // localhost:${Port:0}/admin/tracking/search?text=java
    @GetMapping("/admin/tracking/search")
    public String searchForms(@RequestParam(value = "text") String text,
                              Model model){
        List<TrackingDto> tracking = trackingService.searchTracking(text);
        model.addAttribute("allTracking", tracking);
        return "admin/tracking";
    }
}
