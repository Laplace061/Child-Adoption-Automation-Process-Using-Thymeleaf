package com.interswitch.academy.adoptionautomationsystem.controller;

import com.interswitch.academy.adoptionautomationsystem.dto.AdoptiveParentDto;
import com.interswitch.academy.adoptionautomationsystem.dto.DocumentsDto;
import com.interswitch.academy.adoptionautomationsystem.service.DocumentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DocumentsController {

    private DocumentsService documentsService;

    public DocumentsController(DocumentsService documentsService) {
        this.documentsService = documentsService;
    }

    @GetMapping("/admin/documents")
    public String getAllDocuments(Model model){
        List<DocumentsDto> documents = documentsService.findAllDocuments();
        model.addAttribute("allDocuments", documents);
        return "/admin/documents";  // return a view
    }
}
