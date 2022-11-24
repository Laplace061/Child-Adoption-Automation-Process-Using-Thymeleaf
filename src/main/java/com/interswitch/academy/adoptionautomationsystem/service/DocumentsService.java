package com.interswitch.academy.adoptionautomationsystem.service;

import com.interswitch.academy.adoptionautomationsystem.dto.DocumentsDto;
import com.interswitch.academy.adoptionautomationsystem.dto.RequestDto;
import com.interswitch.academy.adoptionautomationsystem.entities.Documents;

import java.util.List;

public interface DocumentsService {


    List<DocumentsDto> findAllDocuments();

    // List<Documents> uploadDocument(MultipartFile[] files) throws IOException;

    Documents getByFileName(String docName);
}
