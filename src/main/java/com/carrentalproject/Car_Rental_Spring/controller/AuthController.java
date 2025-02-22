package com.carrentalproject.Car_Rental_Spring.controller;



import com.carrentalproject.Car_Rental_Spring.model.User;
import com.carrentalproject.Car_Rental_Spring.security.JWTUtils;
import com.carrentalproject.Car_Rental_Spring.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JWTUtils jwtUtils;

    public AuthController(UserService userService, JWTUtils jwtUtils) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        Optional<User> storedUser = userService.findByUsername(user.getUsername());
        if (storedUser.isPresent() && storedUser.get().getPassword().equals(user.getPassword())) {
            String token = jwtUtils.generateToken(user.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
