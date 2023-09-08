package com.example.FINAL.service.serviceimpl;

import com.example.FINAL.dto.EventDto;
import com.example.FINAL.models.Club;
import com.example.FINAL.models.Event;
import com.example.FINAL.repository.ClubRepository;
import com.example.FINAL.repository.EventRepository;
import com.example.FINAL.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @Autowired
    public EventServiceImpl(ClubRepository clubRepository,EventRepository eventRepository) {
        this.clubRepository = clubRepository;
        this.eventRepository=eventRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club=clubRepository.findById(clubId).get();
        Event event=mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    private Event mapToEvent(EventDto eventDto) {
        return Event.builder().
                id(eventDto.getId()).
                name(eventDto.getName()).
                startTime(eventDto.getStartTime()).
                endTime(eventDto.getEndTime()).
                type(eventDto.getType()).
                photoUrl(eventDto.getPhotoUrl()).
                createdOn(eventDto.getCreatedOn()).
                updatedOn(eventDto.getUpdatedOn())
                .build();
    }
}
