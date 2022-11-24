package com.interswitch.academy.adoptionautomationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentsDto {

    private String id;
    private String fileName;
    private String fileURL;

    public DocumentsDto(String filename, String url) {
    }
}
