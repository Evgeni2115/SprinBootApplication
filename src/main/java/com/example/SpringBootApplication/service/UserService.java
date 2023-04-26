package com.example.SpringBootApplication.service;

import com.example.SpringBootApplication.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    List<User> getAllUsers();

    User getById(Long id);

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
