package com.interswitch.academy.adoptionautomationsystem.service;

import com.interswitch.academy.adoptionautomationsystem.dto.TrackingDto;
import com.interswitch.academy.adoptionautomationsystem.entities.Tracking;

import java.util.List;

public interface TrackingService {

    List<TrackingDto> findAllTracking();
    Tracking addTracking(TrackingDto trackingDto);
    TrackingDto findTrackingById(String trackingId);
    void updateTracking(TrackingDto trackingDto);
    void deleteTracking(String trackingId);

}
