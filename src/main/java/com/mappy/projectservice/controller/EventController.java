package com.mappy.projectservice.controller;

import com.mappy.projectservice.models.Event;
import com.mappy.projectservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/event")
public class EventController {
    private EventService eventService;
    @Autowired
    public EventController(EventService eventService) { this.eventService = eventService; }
    @GetMapping
    public Iterable<Event> getAll() { return eventService.getAll(); }
    @GetMapping(path= "/{eventId}")
    public Optional<Event> getById(@PathVariable Long eventId) { return eventService.getById(eventId); }
    @PostMapping
    public Event save(@RequestBody Event event) {
        LocalDateTime currentDate = LocalDateTime.now();
        event.setDate(currentDate);
        return eventService.save(event); }
    @PutMapping
    public Event update(@RequestBody Event event) { return eventService.update(event); }
    @DeleteMapping
    public void delete(@RequestBody Event event) { eventService.delete(event); }
}
