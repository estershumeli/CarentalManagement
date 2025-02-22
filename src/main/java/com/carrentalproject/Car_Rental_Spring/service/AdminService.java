package com.carrentalproject.Car_Rental_Spring.service;

import com.carrentalproject.Car_Rental_Spring.model.User;
import com.carrentalproject.Car_Rental_Spring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }
}

