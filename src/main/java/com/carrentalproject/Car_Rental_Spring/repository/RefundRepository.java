package com.carrentalproject.Car_Rental_Spring.repository;



import com.carrentalproject.Car_Rental_Spring.model.Refund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefundRepository extends JpaRepository<Refund, Long> {
}
