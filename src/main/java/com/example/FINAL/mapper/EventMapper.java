package com.example.FINAL.mapper;

import com.example.FINAL.dto.EventDto;
import com.example.FINAL.models.Event;

public class EventMapper {
    public static Event mapToEvent(EventDto eventDto) {
        return Event.builder().
                id(Math.toIntExact(eventDto.getId())).
                name(eventDto.getName()).
                startTime(eventDto.getStartTime()).
                endTime(eventDto.getEndTime()).
                type(eventDto.getType()).
                photoUrl(eventDto.getPhotoUrl()).
                createdOn(eventDto.getCreatedOn()).
                updatedOn(eventDto.getUpdatedOn()).
                club(eventDto.getClub())
                .build();
    }
    public static EventDto mapToEventDto(Event event) {
        return EventDto.builder().
                id(Long.valueOf(event.getId())).
                name(event.getName()).
                startTime(event.getStartTime()).
                endTime(event.getEndTime()).
                type(event.getType()).
                photoUrl(event.getPhotoUrl()).
                createdOn(event.getCreatedOn()).
                updatedOn(event.getUpdatedOn()).
                club(event.getClub())
                .build();
    }
}
