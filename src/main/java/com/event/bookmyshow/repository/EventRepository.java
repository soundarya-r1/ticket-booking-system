package com.event.bookmyshow.repository;

import com.event.bookmyshow.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
