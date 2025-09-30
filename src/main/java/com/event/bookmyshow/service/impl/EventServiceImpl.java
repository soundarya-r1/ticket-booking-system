package com.event.bookmyshow.service.impl;

import com.event.bookmyshow.entity.Event;
import com.event.bookmyshow.exception.ResourceNotFoundException;
import com.event.bookmyshow.repository.EventRepository;
import com.event.bookmyshow.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event not Found"));
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Long eventId, Event event) {
        return eventRepository.findById(eventId).map(existingEvent -> {
            existingEvent.setName(event.getName());
            existingEvent.setDescription(event.getDescription());
            existingEvent.setEventType(event.getEventType());
            existingEvent.setLocation(event.getLocation());
            existingEvent.setEventDate(event.getEventDate());
            existingEvent.setTotalSeats(event.getTotalSeats());
            existingEvent.setAvailableSeats(event.getAvailableSeats());
            existingEvent.setStatus(event.getStatus());
            return eventRepository.save(existingEvent);
        }).orElseThrow(() -> new ResourceNotFoundException("Event not Found"));
    }

    @Override
    public boolean deleteEvent(Long eventId) {
        if (eventRepository.existsById(eventId)) {
            eventRepository.deleteById(eventId);
            return true;
        }
        return false;
    }
}
