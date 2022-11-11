package com.interswitch.academy.adoptionautomationsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @Column(nullable = false)
    private boolean inheritanceStatus;
    private String descriptionOfCultureOnAdoption;
    private String otherInfo;
    @OneToMany
    private Set<Documents> files;
    @Column(nullable = false)
    private String Witness;
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime dateOfAdoption;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

}
