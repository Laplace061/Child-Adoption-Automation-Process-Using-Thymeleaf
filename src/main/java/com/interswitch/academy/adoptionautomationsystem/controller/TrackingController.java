package com.interswitch.academy.adoptionautomationsystem.controller;

import com.interswitch.academy.adoptionautomationsystem.dto.RequestDto;
import com.interswitch.academy.adoptionautomationsystem.dto.TrackingDto;
import com.interswitch.academy.adoptionautomationsystem.service.TrackingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@Controller
public class TrackingController {

    private TrackingService trackingService;

    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping("/admin/tracking")
    public String getAllTracking(Model model){
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
