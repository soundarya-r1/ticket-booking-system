package com.event.bookmyshow.repository;

import com.event.bookmyshow.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

}
