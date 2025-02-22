package com.carrentalproject.Car_Rental_Spring.repository;



import com.carrentalproject.Car_Rental_Spring.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}

