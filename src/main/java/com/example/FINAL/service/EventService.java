package com.example.FINAL.service;

import com.example.FINAL.dto.EventDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EventService {
     void createEvent(Long clubId, EventDto eventDto);
     List<EventDto> findAllEvents();

     EventDto findByEventId(Long eventId);

     void upDateEvent(EventDto eventDto);

    void deleteEvent(long eventId);
}
