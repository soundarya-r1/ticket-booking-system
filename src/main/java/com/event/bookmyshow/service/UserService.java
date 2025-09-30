package com.event.bookmyshow.service;

import com.event.bookmyshow.entity.Users;

import java.util.List;

public interface UserService {
    List<Users> getAllUsers();
    Users getUserById(Long userId);
    Users createUser(Users user);
    Users updateUsers(Long userId, Users user);
    boolean deleteUsers(Long userId);
}
