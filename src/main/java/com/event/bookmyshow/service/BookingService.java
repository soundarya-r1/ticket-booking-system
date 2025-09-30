package com.event.bookmyshow.service;

import com.event.bookmyshow.entity.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking getBookingById(Long bookingId);
    Booking createBooking(Booking booking);
    Booking updateBooking(Long bookingId, Booking booking);
    boolean deleteBooking(Long bookingId);
}
