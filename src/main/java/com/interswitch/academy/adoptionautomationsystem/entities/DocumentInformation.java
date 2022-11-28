package com.interswitch.academy.adoptionautomationsystem.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentInformation {

    private String fileInfoName;
    private String fileURL;

    public DocumentInformation() {
    }

    public DocumentInformation(String fileInfoName, String fileURL) {
        this.fileInfoName = fileInfoName;
        this.fileURL = fileURL;
    }
}
