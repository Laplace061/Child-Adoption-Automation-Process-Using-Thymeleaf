package com.interswitch.academy.adoptionautomationsystem.service.serviceImpl;

import com.interswitch.academy.adoptionautomationsystem.dto.DocumentsDto;
import com.interswitch.academy.adoptionautomationsystem.dto.RequestDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptionRequest;
import com.interswitch.academy.adoptionautomationsystem.entities.Documents;
import com.interswitch.academy.adoptionautomationsystem.mapper.DocumentsMapper;
import com.interswitch.academy.adoptionautomationsystem.mapper.RequestMapper;
import com.interswitch.academy.adoptionautomationsystem.repository.DocumentsRepository;
import com.interswitch.academy.adoptionautomationsystem.service.DocumentsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentsServiceImpl implements DocumentsService {

    private DocumentsRepository documentsRepository;

    public DocumentsServiceImpl(DocumentsRepository documentsRepository) {
        this.documentsRepository = documentsRepository;
    }


    @Override
    public List<DocumentsDto> findAllDocuments() {
        List<Documents> documents = documentsRepository.findAll();
        return documents.stream().map(DocumentsMapper::mapToDocumentsDto)  // Short form
                .collect(Collectors.toList());
    }
}