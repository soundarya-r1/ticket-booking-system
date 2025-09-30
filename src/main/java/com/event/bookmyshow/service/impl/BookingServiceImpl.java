package com.event.bookmyshow.service.impl;

import com.event.bookmyshow.entity.Booking;
import com.event.bookmyshow.entity.Event;
import com.event.bookmyshow.exception.ResourceNotFoundException;
import com.event.bookmyshow.repository.BookingRepository;
import com.event.bookmyshow.repository.EventRepository;
import com.event.bookmyshow.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException("Booking not Found"));
    }

    @Override
    public Booking createBooking(Booking booking) {
        Event event = eventRepository.findById(booking.getEvent().getEventId()).orElse(null);
        if (event == null) {
            return null;
        }

        if (event.getAvailableSeats() >= booking.getSeatsBooked()) {
            event.setAvailableSeats(event.getAvailableSeats() - booking.getSeatsBooked());
            eventRepository.save(event);

            booking.setStatus("CONFIRMED");
            return bookingRepository.save(booking);
        } else {
            throw new RuntimeException("Not enough seats available");
        }
    }

    @Override
    public Booking updateBooking(Long bookingId, Booking booking) {
        return bookingRepository.findById(bookingId).map(existingBooking -> {
            existingBooking.setSeatsBooked(booking.getSeatsBooked());
            existingBooking.setStatus(booking.getStatus());
            existingBooking.setTotalAmount(booking.getTotalAmount());
            return bookingRepository.save(existingBooking);
        }).orElseThrow(() -> new ResourceNotFoundException("Booking not Found"));
    }

    @Override
    public boolean deleteBooking(Long bookingId) {
        if (bookingRepository.existsById(bookingId)) {
            bookingRepository.deleteById(bookingId);
            return true;
        }
        return false;
    }
}
