package com.example.eventmanagementsystem.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.eventmanagementsystem.model.*;
import com.example.eventmanagementsystem.service.*;

@RestController
public class EventController {

    @Autowired
    public EventJpaService service;

    @GetMapping("/events")
    public ArrayList<Event> getEvents() {
        return service.getEvents();
    }

    @GetMapping("/events/{eventId}")
    public Event getEventById(@PathVariable("eventId") int eventId) {
        return service.getEventById(eventId);
    }

    @PostMapping("/events")
    public Event addEvent(@RequestBody Event event) {
        return service.addEvent(event);
    }

    @PutMapping("/events/{eventId}")
    public Event updateEvent(@PathVariable("eventId") int eventId, @RequestBody Event event) {
        return service.updateEvent(eventId, event);
    }

    @DeleteMapping("/events/{eventId}")
    public void deleteEvent(@PathVariable("eventId") int eventId) {
        service.deleteEvent(eventId);
    }

    @GetMapping("/events/{eventId}/sponsors")
    public List<Sponsor> getEventSponsors(@PathVariable("eventId") int eventId) {
        return service.getEventSponsors(eventId);
    }

}
