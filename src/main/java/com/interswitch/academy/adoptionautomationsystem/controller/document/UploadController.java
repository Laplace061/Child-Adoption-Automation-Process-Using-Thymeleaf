package com.interswitch.academy.adoptionautomationsystem.controller.document;

import com.interswitch.academy.adoptionautomationsystem.entities.Document;
import com.interswitch.academy.adoptionautomationsystem.repository.DocumentRepository;
import com.interswitch.academy.adoptionautomationsystem.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadController {

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private IdUtil idUtil;


    /**
     * Get index page
     *
     * @return index
     */

    @GetMapping("/upload")
    public String getIndexFilePage() {
        return "/admin/upload";
    }

    @PostMapping("/upload")
    public String uploadFiles(@RequestParam("files") MultipartFile[] multipartFiles, Model model) {
        List<String> listFileNames = new ArrayList<>();

        try {
            List<Document> storeFiles = new ArrayList<>();

            for (MultipartFile file : multipartFiles) {
                Document document = documentRepository.findByFileName(file.getOriginalFilename());

                if (document != null) {
                    document.setFileByte(file.getBytes());
                } else {
                    document = new Document(file.getOriginalFilename(), file.getContentType(), file.getBytes());
                }
                listFileNames.add(file.getOriginalFilename());
                String docId = idUtil.generateId();
                document.setFileId(docId);
                storeFiles.add(document);
            }

            // save all files
            documentRepository.saveAll(storeFiles);

            // successfully message after uploaded
            model.addAttribute("message", "Files uploaded successfully!");
            model.addAttribute("files", listFileNames);
        } catch (Exception e) {
            // fail message for unsupported file or max size
            model.addAttribute("message", "Failed to upload files");
            model.addAttribute("files", listFileNames);
        }
        return "/admin/upload";
    }
}
