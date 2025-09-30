package com.event.bookmyshow.service;

import com.event.bookmyshow.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();
    Event getEventById(Long eventId);
    Event createEvent(Event event);
    Event updateEvent(Long eventId, Event event);
    boolean deleteEvent(Long eventId);
}
