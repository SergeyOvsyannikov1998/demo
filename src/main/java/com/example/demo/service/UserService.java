package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void addUser(User user);
    void removeUser(Long id);
    User getUser(Long id);
    List<User> getAllUsers();

    User getUserByName(String name);
}
