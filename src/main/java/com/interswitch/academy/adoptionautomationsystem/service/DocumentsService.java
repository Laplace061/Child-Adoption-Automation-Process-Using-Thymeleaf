package com.interswitch.academy.adoptionautomationsystem.service;

import com.interswitch.academy.adoptionautomationsystem.dto.DocumentsDto;
import com.interswitch.academy.adoptionautomationsystem.dto.RequestDto;

import java.util.List;

public interface DocumentsService {

    List<DocumentsDto> findAllDocuments();
}
