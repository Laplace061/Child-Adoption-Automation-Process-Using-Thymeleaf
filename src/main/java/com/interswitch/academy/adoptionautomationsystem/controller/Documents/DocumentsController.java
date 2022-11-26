package com.interswitch.academy.adoptionautomationsystem.controller.Documents;

import com.interswitch.academy.adoptionautomationsystem.service.DocumentsService;
import org.springframework.stereotype.Controller;

@Controller
public class DocumentsController {

    private DocumentsService documentsService;

    public DocumentsController(DocumentsService documentsService) {
        this.documentsService = documentsService;
    }

//    @GetMapping("/admin/documents")
//    public String getAllDocuments(Model model){
//        List<DocumentsDto> documents = documentsService.findAllDocuments();
//        model.addAttribute("allDocuments", documents);
//        return "/admin/documents";  // return a view
//    }
}
