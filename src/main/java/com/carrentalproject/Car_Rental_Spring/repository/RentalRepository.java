package com.carrentalproject.Car_Rental_Spring.repository;



import com.carrentalproject.Car_Rental_Spring.model.Rental;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
