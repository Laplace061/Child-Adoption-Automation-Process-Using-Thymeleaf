package com.interswitch.academy.adoptionautomationsystem.entities;

import com.interswitch.academy.adoptionautomationsystem.entities.enums.InheritanceEligibility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class AdoptionForm {
    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "adoptiveParent_id")
    private AdoptiveParent adoptiveParent;

    @Column(nullable = false)
    private int preferredAgeOfChild;

    private int durationOfAdoption;

    @Enumerated(EnumType.STRING)
    private InheritanceEligibility inheritanceEligibility;

//    private String descriptionOfCultureOnAdoption;
    private String otherInfo;

    @OneToMany
    private Set<Document> files;

    @Column(nullable = false)
    private String Witness;

    @Temporal(TemporalType.DATE)
    private Date dateOfAdoption;

    @OneToOne
    @JoinColumn(name = "request_id")
    private AdoptionRequest request;
}
