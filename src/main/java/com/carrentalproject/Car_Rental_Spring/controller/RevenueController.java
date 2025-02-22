package com.carrentalproject.Car_Rental_Spring.controller;


import com.carrentalproject.Car_Rental_Spring.model.Revenue;
import com.carrentalproject.Car_Rental_Spring.service.RevenueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/revenue")
public class RevenueController {

    private final RevenueService revenueService;

    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @GetMapping
    public List<Revenue> getRevenue() {
        return revenueService.getAllRevenue();
    }

    @PostMapping
    public Revenue addRevenue(@RequestParam double amount) {
        return revenueService.addRevenue(amount);
    }
}

