package com.example.SpringBootApplication.service;

import com.example.SpringBootApplication.model.User;
import com.example.SpringBootApplication.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    @Transactional
    public void updateUser(Long id, User user) {
        User existingUser = userRepository.getById(id);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setLastName(user.getLastName());
            userRepository.save(existingUser);
        }
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
