package com.interswitch.academy.adoptionautomationsystem.controller;

import com.interswitch.academy.adoptionautomationsystem.dto.RequestDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.RequestStatus;
import com.interswitch.academy.adoptionautomationsystem.repository.AdoptiveParentRepository;
import com.interswitch.academy.adoptionautomationsystem.service.AdoptionRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class AdoptionRequestController {

    private AdoptiveParentRepository parentRepository;
    private AdoptionRequestService requestService;

    public AdoptionRequestController(AdoptiveParentRepository parentRepository, AdoptionRequestService requestService) {
        this.parentRepository = parentRepository;
        this.requestService = requestService;
    }

    //Get request and return model and view
    @GetMapping("/admin/requests")
    public String getAllRequests(Model model){
        List<RequestDto> requests = requestService.findAllRequest();
        model.addAttribute("allRequest", requests);
        return "/admin/requests";  // return a view
    }

    @GetMapping("admin/requests/newrequest")
    public String newRequestForm(Model model){

        List<AdoptiveParent> parents = parentRepository.findAll();

        RequestDto requestDto = new RequestDto();
        model.addAttribute("create_request", requestDto);
        model.addAttribute("listParents", parents);
        return "admin/create-request";
    }

    @PostMapping("admin/requests")
    public String createRequest(@Valid @ModelAttribute("create_request") RequestDto requestDto, BindingResult result, Model model){

        log.info("Dto is:  {}", requestDto );
        if(result.hasErrors()){
            model.addAttribute("create_request", requestDto);
            return "admin/create-request";
        }

       requestDto.setStatus(RequestStatus.PENDING);
        requestService.createRequest(requestDto);
        return "redirect:/admin/requests";

    }

    // handler method to handle edit post request
    @GetMapping("/admin/requests/{requestId}/edit")
    public String editRequestForm(@PathVariable("requestId") String requestId,
                               Model model){

        RequestDto requestDto = requestService.findRequestById(requestId);
        model.addAttribute("request", requestDto);
        return "admin/edit_request";
    }

    // handler method to handle edit post form submit request
    @PostMapping("/admin/requests/{requestId}")
    public String updateRequest(@PathVariable("requestId") String requestId,
                             @Valid @ModelAttribute("request") RequestDto request,
                             BindingResult result,
                             Model model){
        if(result.hasErrors()){
            model.addAttribute("request", request);
            return "admin/edit_request";
        }

        request.setId(requestId);
        requestService.updateRequest(request);
        return "redirect:/admin/requests";
    }

    // handler method to handle delete request
    @GetMapping("/admin/requests/{requestId}/delete")
    public String deleteRequest(@PathVariable("requestId") String requestId){
        this.requestService.deleteRequest(requestId);
        return "redirect:/admin/requests";
    }

    // handler method to handle view Adoption Request
    @GetMapping("/admin/requests/{requestId}/view")
    public String viewRequests(@PathVariable("requestId") String requestId,
                               Model model){
        RequestDto requestDto = requestService.findRequestById(requestId);
        model.addAttribute("request", requestDto);
        return "admin/view_request";

    }

    // handler method to handle search adoption request
    // localhost:${Port:0}/admin/requests/search?text=java
    @GetMapping("/admin/requests/search")
    public String searchForms(@RequestParam(value = "text") String text,
                              Model model){
        List<RequestDto> request = requestService.searchRequest(text);
        model.addAttribute("allRequest", request);
        return "admin/requests";
    }
}
