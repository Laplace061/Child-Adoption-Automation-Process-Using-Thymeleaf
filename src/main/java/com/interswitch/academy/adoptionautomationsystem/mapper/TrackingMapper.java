package com.interswitch.academy.adoptionautomationsystem.mapper;

import com.interswitch.academy.adoptionautomationsystem.dto.TrackingDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.Tracking;

public class TrackingMapper {

    public static Tracking mapToTracking(TrackingDto trackingDto){

        return Tracking.builder()
                .id(trackingDto.getId())
                .child(trackingDto.getChild())
                .adoptiveParent(trackingDto.getAdoptiveParent())
                .staffAssigned(trackingDto.getStaffAssigned())
                .lastChecked(trackingDto.getLastChecked())
                .nextChecked(trackingDto.getNextChecked())
                .location(trackingDto.getLocation())
                .status(trackingDto.getStatus())
                .comment(trackingDto.getComment())
                .build();
    }

    public static TrackingDto mapToTrackingDto(Tracking tracking){

        return TrackingDto.builder()
                .id(tracking.getId())
                .child(tracking.getChild())
                .adoptiveParent(tracking.getAdoptiveParent())
                .staffAssigned(tracking.getStaffAssigned())
                .lastChecked(tracking.getLastChecked())
                .nextChecked(tracking.getNextChecked())
                .location(tracking.getLocation())
                .status(tracking.getStatus())
                .comment(tracking.getComment())
                .build();
    }
}
