package com.example.FINAL.controller;

import com.example.FINAL.dto.EventDto;
import com.example.FINAL.models.Event;
import com.example.FINAL.service.EventService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping( "/events")
    public String eventList(Model model)
    {
        List<EventDto> events=eventService.findAllEvents();
        model.addAttribute("events",events);
        return "events-list";
    }
    @GetMapping("/events/{eventId}")
    public String  viewEvent(@PathVariable("eventId") Long eventId,Model model)
    {
      EventDto eventDto=eventService.findByEventId(eventId);
      model.addAttribute("event",eventDto);
      return "events-detail";
    }

    @GetMapping("/events/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") Long eventId,Model model)
    {
        EventDto event=eventService.findByEventId(eventId);
        model.addAttribute("event",event);
        return "events-edit";
    }
    @PostMapping("/events/{eventId}/edit")
    public  String updateEvent(@PathVariable("eventId") Long eventId,
                               @Valid @ModelAttribute("event") EventDto eventDto,
                               BindingResult result,
                               Model model)
    {
        if(result.hasErrors())
        {
            model.addAttribute("eventDto",eventDto);
            return "events-edit";
        }
        EventDto eventDto1=eventService.findByEventId(eventId);
        eventDto.setId(eventId);
        eventDto.setClub(eventDto1 .getClub());
        eventService.upDateEvent(eventDto);
        return "redirect:/events";
    }
    @GetMapping("/events/{clubId}/new")
    public String createEventForm(@PathVariable("clubId") Long clubId, Model model)
    {
        Event  event=new Event();
        model.addAttribute("clubId",clubId);
        model.addAttribute("event",event);
        return "events-create";
    }
    @PostMapping("/events/{clubId}")
    public String createEvent(@PathVariable("clubId") Long clubId,@Valid @ModelAttribute("event") EventDto eventDto,
                              BindingResult result,
                              Model model)
    {
        if(result.hasErrors())
        {
            model.addAttribute("eventDto",eventDto);
            return "clubs-create";
        }
        eventService.createEvent(clubId,eventDto);
        return "redirect:/clubs/"+clubId;
    }

    @GetMapping("/events/{eventId}/delete")
    public String deleteEvent(@PathVariable("eventId") long eventId)
    {
        eventService.deleteEvent(eventId);
        return "redirect:/events";
    }
}
