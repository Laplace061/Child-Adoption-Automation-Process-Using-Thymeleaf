package com.interswitch.academy.adoptionautomationsystem.service.serviceImpl;

import com.interswitch.academy.adoptionautomationsystem.dto.TrackingDto;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.Tracking;
import com.interswitch.academy.adoptionautomationsystem.mapper.TrackingMapper;
import com.interswitch.academy.adoptionautomationsystem.repository.TrackingRepository;
import com.interswitch.academy.adoptionautomationsystem.service.TrackingService;
import com.interswitch.academy.adoptionautomationsystem.util.IdUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrackingServiceImpl implements TrackingService {

    private IdUtil idUtil;
    private TrackingRepository trackingRepository;

    public TrackingServiceImpl(IdUtil idUtil, TrackingRepository trackingRepository) {
        this.idUtil = idUtil;
        this.trackingRepository = trackingRepository;
    }

    @Override
    public List<TrackingDto> findAllTracking() {

        List<Tracking> trackings = trackingRepository.findAll();
        return trackings.stream().map(TrackingMapper::mapToTrackingDto)
                .collect(Collectors.toList());
    }

    @Override
    public Tracking addTracking(TrackingDto trackingDto) {

            String trackingId = idUtil.generateId(); // UUID.randomUUID().toString() was moved to the ChildIdUtil class
            trackingDto.setId(trackingId);
            Tracking trackingInfo= TrackingMapper.mapToTracking(trackingDto);
            trackingRepository.save(trackingInfo);
            return trackingInfo;
    }

    @Override
    public TrackingDto findTrackingById(String trackingId) {
        Tracking tracking = trackingRepository.findById(trackingId).get();
        return TrackingMapper.mapToTrackingDto(tracking);
    }

    @Override
    public void updateTracking(TrackingDto trackingDto) {
        Tracking tracking = TrackingMapper.mapToTracking(trackingDto);
        trackingRepository.save(tracking);
    }

    @Override
    public void deleteTracking(String trackingId) {

        trackingRepository.deleteById(trackingId);
    }

    @Override
    public List<TrackingDto> searchTracking(String text) {
        List<Tracking> tracking = trackingRepository.searchTracking(text);
        return tracking.stream()
                .map(TrackingMapper::mapToTrackingDto)
                .collect(Collectors.toList());
    }
}

