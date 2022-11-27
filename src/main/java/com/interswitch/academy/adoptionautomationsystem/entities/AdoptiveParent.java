package com.interswitch.academy.adoptionautomationsystem.entities;

import com.interswitch.academy.adoptionautomationsystem.entities.enums.*;
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
@Table(name = "Adoptive_Parent") // To override the table name
public class AdoptiveParent {

    @Id
    private String id;
    private String name;
    private String occupation;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;

    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Enumerated(EnumType.STRING)
    private Religion religion;

    @Enumerated(EnumType.STRING)
    private Education qualification;

    private String nationality;
    private String officialAddress;

    private String homeAddress;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private AdoptionStatus status;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Documents> documents;

    @OneToOne(mappedBy = "parent", cascade = CascadeType.ALL)
    private Children child;

    @OneToOne(mappedBy = "parent")
    private AdoptionRequest request;

    @OneToOne(mappedBy = "adoptiveParent")
    private Tracking tracking;

}
