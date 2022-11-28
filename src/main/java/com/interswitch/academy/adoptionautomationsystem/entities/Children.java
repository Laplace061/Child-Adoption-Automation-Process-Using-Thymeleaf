package com.interswitch.academy.adoptionautomationsystem.entities;

import com.interswitch.academy.adoptionautomationsystem.entities.enums.AdoptionStatus;
import com.interswitch.academy.adoptionautomationsystem.entities.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Children {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date dob;
    private String motherName;
    private String fatherName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private AdoptionStatus status;
    private String orphanageCode;
    private String nationality;
    @Lob
    private String image;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parent_id")
    private AdoptiveParent parent;
    @ManyToOne
    @JoinColumn(name = "guardian_id")
    private GuardianAdLitem guardian;
}
