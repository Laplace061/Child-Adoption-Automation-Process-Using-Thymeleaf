package com.interswitch.academy.adoptionautomationsystem.dto;

import com.interswitch.academy.adoptionautomationsystem.entities.AdoptedChildren;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.Children;
import com.interswitch.academy.adoptionautomationsystem.entities.GuardianAdLitem;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.TrackingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrackingDto {

    private String id;
    private AdoptedChildren child;
    private AdoptiveParent adoptiveParent;
    private GuardianAdLitem staffAssigned;
    private String location;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastChecked;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nextChecked;
    private TrackingStatus status;
    private String comment; //JQUERY CKEditor
}

