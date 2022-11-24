package com.interswitch.academy.adoptionautomationsystem.controller.Documents;

import com.interswitch.academy.adoptionautomationsystem.entities.Documents;
import com.interswitch.academy.adoptionautomationsystem.repository.DocumentsRepository;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadController {

    DocumentsRepository documentsRepository;

    public UploadController(DocumentsRepository documentsRepository) {
        this.documentsRepository = documentsRepository;
    }

    @PostMapping("/upload")
    public String index() {
        return "admin/create-documents";
    }

    @RequestMapping("/upload")
    public String uploadDocument(@RequestParam("files") MultipartFile[] files,  RedirectAttributes redirectAttributes) {

        List<String> fileNames = new ArrayList<>();

        try {
            List<Documents> storedFile = new ArrayList<>();

            for (MultipartFile file : files) {
                Documents document = documentsRepository.findByFileName(file.getOriginalFilename());
                if (document != null) {
                    // update new contents
                    document.setData(file.getBytes());
                } else {
                    document = new Documents(file.getOriginalFilename(), file.getContentType(), file.getBytes());
                }

                fileNames.add(file.getOriginalFilename());
                storedFile.add(document);
            }

            // Save all Files to database
            documentsRepository.saveAll(storedFile);

            redirectAttributes.addFlashAttribute("message", "Files uploaded successfully!");
            redirectAttributes.addFlashAttribute("files", fileNames);
        } catch (Exception e) {
           redirectAttributes.addFlashAttribute("message", "Upload Failed!");
            redirectAttributes.addFlashAttribute("files", fileNames);
        }

        return "admin/create-documents";
    }
}
