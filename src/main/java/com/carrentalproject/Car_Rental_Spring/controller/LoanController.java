package com.carrentalproject.Car_Rental_Spring.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.carrentalproject.Car_Rental_Spring.service.LoanService;
import com.carrentalproject.Car_Rental_Spring.model.Loan;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public Loan rentCar(@RequestBody Loan loan) {
        return loanService.processRental(loan);
    }
}


