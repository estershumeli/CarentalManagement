package com.carrentalproject.Car_Rental_Spring.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.carrentalproject.Car_Rental_Spring.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}


