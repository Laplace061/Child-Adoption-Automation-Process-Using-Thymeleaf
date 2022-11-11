package com.interswitch.academy.adoptionautomationsystem.service;

import com.interswitch.academy.adoptionautomationsystem.dto.ChildrenDto;
import com.interswitch.academy.adoptionautomationsystem.dto.TrackingDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.Children;
import com.interswitch.academy.adoptionautomationsystem.entities.Tracking;

import java.util.List;

public interface TrackingService {

    List<TrackingDto> findAllTracking();
    Tracking addTracking(TrackingDto trackingDto);
}
