package com.interswitch.academy.adoptionautomationsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Documents {

    @Id
    private String id;

    private String fileName;
    private String fileType;
    private String mimeType;  // Document format
    @Lob
    private byte[] data;
//    @ManyToOne()
//    @JoinColumn(name = "parent_id")
//    AdoptiveParent parent;

    public Documents(String originalFilename, String contentType, byte[] bytes) {
    }
}