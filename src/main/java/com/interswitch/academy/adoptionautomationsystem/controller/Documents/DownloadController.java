package com.interswitch.academy.adoptionautomationsystem.controller.Documents;

import com.interswitch.academy.adoptionautomationsystem.dto.DocumentsDto;
import com.interswitch.academy.adoptionautomationsystem.entities.Documents;
import com.interswitch.academy.adoptionautomationsystem.repository.DocumentsRepository;
import com.interswitch.academy.adoptionautomationsystem.service.DocumentsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DownloadController {

    DocumentsService documentsService;
    DocumentsRepository documentsRepository;

    public DownloadController(DocumentsService documentsService, DocumentsRepository documentsRepository) {
        this.documentsService = documentsService;
        this.documentsRepository = documentsRepository;
    }

    /*
     * Retrieve Files' Information
     */
    @GetMapping("/download")
    public String getListFiles(Model model) {
        List<DocumentsDto> documentDto = documentsRepository.findAll().stream().map(
                        document -> {
                            String filename = document.getFileName();
                            String url = MvcUriComponentsBuilder.fromMethodName(DownloadController.class,
                                    "downloadFile", document.getFileName()).build().toString();
                            return new DocumentsDto(filename, url);
                        }
                )
                .collect(Collectors.toList());

        model.addAttribute("files", documentDto);
        return "admin/documents";
    }

    /*
     * Download Files
     */
    @GetMapping("/download/{filename}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String filename) {
        Documents file = documentsRepository.findByFileName(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .body(file.getData());
    }

    @GetMapping("/admin/documents")
    public String getAllDocuments(Model model){
        List<DocumentsDto> documents = documentsService.findAllDocuments();
        model.addAttribute("allDocuments", documents);
        return "/admin/documents";  // return a view
    }
}