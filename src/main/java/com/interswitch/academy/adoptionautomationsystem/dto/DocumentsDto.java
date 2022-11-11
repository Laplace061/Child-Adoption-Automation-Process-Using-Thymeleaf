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

    private Long id;
    private String fileName;
    private byte[] data;
    //AdoptiveParent parent_id
    //Children child_id
}
