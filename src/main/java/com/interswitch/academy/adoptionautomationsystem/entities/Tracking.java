package com.interswitch.academy.adoptionautomationsystem.entities;

import com.interswitch.academy.adoptionautomationsystem.entities.enums.TrackingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Tracking {

    @Id
    private String id;
    @OneToOne
    private AdoptedChildren child;
    @OneToOne
    @JoinColumn(name = "parent_id")
    private AdoptiveParent adoptiveParent;
    @ManyToOne
    @JoinColumn(name = "staff_assigned_id")
    private GuardianAdLitem staffAssigned;

    private String location;
    @Temporal(TemporalType.DATE)
    private Date lastChecked;
    @Temporal(TemporalType.DATE)
    private Date nextChecked;
    private TrackingStatus status;
    private String comment;
}
