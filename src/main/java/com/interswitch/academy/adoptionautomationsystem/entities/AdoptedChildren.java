package com.interswitch.academy.adoptionautomationsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Adopted_Children")
public class AdoptedChildren {
    // Use the same ID as children
    @Id
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adoptiveParent_id")
    private AdoptiveParent parent;

    @CreationTimestamp
    private LocalDateTime leaveDate;

    @Column(nullable = false)
    @OneToMany()
    @JoinColumn(name = "documents_id")
    private Set<Document> proofOfAdoption;  //signedUndertaking and courtOrder; separate it

}
