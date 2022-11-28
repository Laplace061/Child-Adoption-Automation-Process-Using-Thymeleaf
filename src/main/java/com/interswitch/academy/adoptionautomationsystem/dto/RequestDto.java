package com.interswitch.academy.adoptionautomationsystem.dto;

import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestDto {

    private String id;
    private String location;
    @Size(min = 10, max = 200, message
            = "Reason must be between 10 and 200 characters")
    private String reasonOrPurposeForAdoption;
    private Date requestDate;
    private RequestStatus status;
    private AdoptiveParent parent;
}
