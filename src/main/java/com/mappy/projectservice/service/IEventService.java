package com.mappy.projectservice.service;

import com.mappy.projectservice.models.Event;
import com.mappy.projectservice.models.Project;

import java.util.Optional;

public interface IEventService {
    Event save(Event event);
    Iterable<Event> getAll();
    Optional<Event> getById(Long id);
    Event update(Event event);
    void delete(Event event);
}
