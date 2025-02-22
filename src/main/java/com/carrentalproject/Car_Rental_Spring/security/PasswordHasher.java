package com.carrentalproject.Car_Rental_Spring.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "admin123"; // Replace with the password you want to hash
        String hashedPassword = encoder.encode(rawPassword);
        System.out.println("BCrypt Hashed Password: " + hashedPassword);
    }
}
