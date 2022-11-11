package com.interswitch.academy.adoptionautomationsystem.entities;

import com.interswitch.academy.adoptionautomationsystem.entities.enums.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Request")
public class AdoptionRequest {

    @Id
    private String id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="adoptiveParent_id", referencedColumnName = "id")
    private AdoptiveParent adoptiveParent;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date requestDate;

    private String location;

    @Lob
    private String reasonOrPurposeForAdoption;

    @Enumerated(EnumType.STRING)  //Need to  pre persist as pending
    private RequestStatus status;

//   @OneToOne(cascade = CascadeType.ALL)
//   @JoinColumn(name = "parent_name", referencedColumnName = "name")
 //  private  parentName;
}
