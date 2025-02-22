package com.carrentalproject.Car_Rental_Spring.service;



import com.carrentalproject.Car_Rental_Spring.model.Loan;
import com.carrentalproject.Car_Rental_Spring.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan processRental(Loan loan) {
        loan.setRentalDate(LocalDateTime.now());
        return loanRepository.save(loan);
    }
}

