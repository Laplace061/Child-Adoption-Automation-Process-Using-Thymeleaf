package com.interswitch.academy.adoptionautomationsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class Document {

    @Id
    @Column(name = "file_id")
    private String fileId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;
    @Lob
    @Column(name = "file_byte")
    private byte[] fileByte;

    public Document() {
    }

    public Document(String fileName, String fileType, byte[] fileByte) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileByte = fileByte;
    }
}
