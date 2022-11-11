package com.interswitch.academy.adoptionautomationsystem.controller;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptiveParentDto;
import com.interswitch.academy.adoptionautomationsystem.dto.ChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.dto.TrackingDto;
import com.interswitch.academy.adoptionautomationsystem.service.TrackingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Slf4j
@Controller
public class TrackingController {

    private TrackingService trackingService;

    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping("/admin/tracking")
    public String getAllParents(Model model){
        List<TrackingDto> trackings = trackingService.findAllTracking();
        model.addAttribute("allTracking", trackings);
        return "/admin/tracking";  // return a view
    }

    @GetMapping("admin/tracking/newtracking")
    public String newTrackingForm(Model model) {

        TrackingDto trackingDto = new TrackingDto();
        model.addAttribute("create_tracking", trackingDto);
        return "admin/create-tracking";
    }

    @PostMapping("admin/tracking")
    public String createTracking(@ModelAttribute TrackingDto trackingDto) {

        log.info("Dto is:  {}", trackingDto);

        trackingService.addTracking(trackingDto);
        return "redirect:/admin/tracking";

    }
}
