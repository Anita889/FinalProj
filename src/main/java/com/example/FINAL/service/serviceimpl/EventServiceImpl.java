package com.example.FINAL.service.serviceimpl;

import com.example.FINAL.dto.EventDto;
import com.example.FINAL.models.Club;
import com.example.FINAL.models.Event;
import com.example.FINAL.repository.ClubRepository;
import com.example.FINAL.repository.EventRepository;
import com.example.FINAL.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.FINAL.mapper.EventMapper.mapToEvent;
import static com.example.FINAL.mapper.EventMapper.mapToEventDto;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final ClubRepository clubRepository;

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

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events=eventRepository.findAll();
        return events.stream().map((event)->mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public EventDto findByEventId(Long eventId) {
        Event event=eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }

    @Override
    public void upDateEvent(EventDto eventDto) {
        Event event=mapToEvent(eventDto);
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(long eventId) {
        eventRepository.deleteById(eventId);
    }
}
