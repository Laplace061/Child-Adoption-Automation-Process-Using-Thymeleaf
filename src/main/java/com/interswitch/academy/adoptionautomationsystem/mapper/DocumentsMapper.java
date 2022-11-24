package com.interswitch.academy.adoptionautomationsystem.mapper;

import com.interswitch.academy.adoptionautomationsystem.dto.DocumentsDto;
import com.interswitch.academy.adoptionautomationsystem.entities.Documents;

public class DocumentsMapper {

    public static Documents mapToDocuments(DocumentsDto documentsDto){

        return Documents.builder()
                .id(documentsDto.getId())
                .fileName(documentsDto.getFileName())
                .data(documentsDto.getFileURL().getBytes())
                //.parentId
                //.childId
                .build();
    }

    public static DocumentsDto mapToDocumentsDto(Documents documents){

        return DocumentsDto.builder()
                .id(documents.getId())
                .fileName(documents.getFileName())
                //.parentId
                //.childId
                .build();
    }
}
