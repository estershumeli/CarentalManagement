package com.carrentalproject.Car_Rental_Spring.repository;



import com.carrentalproject.Car_Rental_Spring.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}

