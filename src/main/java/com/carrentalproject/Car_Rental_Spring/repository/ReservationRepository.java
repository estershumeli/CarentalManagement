package com.carrentalproject.Car_Rental_Spring.repository;


import com.carrentalproject.Car_Rental_Spring.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCustomerId(Long customerId);
}

