package com.example.FINAL.service;

import com.example.FINAL.dto.EventDto;
import org.springframework.stereotype.Service;

public interface EventService {
     void createEvent(Long clubId, EventDto eventDto);
}
