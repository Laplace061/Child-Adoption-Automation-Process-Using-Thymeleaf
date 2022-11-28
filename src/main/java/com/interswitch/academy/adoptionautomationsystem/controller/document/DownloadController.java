package com.interswitch.academy.adoptionautomationsystem.controller.document;

import com.interswitch.academy.adoptionautomationsystem.entities.Document;
import com.interswitch.academy.adoptionautomationsystem.entities.DocumentInformation;
import com.interswitch.academy.adoptionautomationsystem.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DocumentRepository documentRepository;

    /**
     * Get and display file stored in the database.
     *
     * @return DownloadController-file page
     */

    @GetMapping("/download/files")
    public String getListOfFiles(Model model) {
        List<DocumentInformation> listDocInfo = documentRepository.findAll()
                .stream()
                .map(document -> {
                            String fileInfoName = document.getFileName();
                            String fileURL = MvcUriComponentsBuilder
                                    .fromMethodName(
                                            DownloadController.class,
                                            "downloadFile",
                                            document.getFileName())
                                    .build()
                                    .toString();
                            return new DocumentInformation(fileInfoName, fileURL);
                        }
                ).collect(Collectors.toList());


        model.addAttribute("files", listDocInfo);
        return "/admin/download";
    }

    /**
     * Get file to DownloadController.
     *
     * @return file from database to be downloaded
     */

    @GetMapping("/download/files/{fileInfoName}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileInfoName) {
        Document downloadFile = documentRepository.findByFileName(fileInfoName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + downloadFile.getFileName() + "\"")
                .body(downloadFile.getFileByte());
    }
}
