package com.carrentalproject.Car_Rental_Spring.service;

import com.carrentalproject.Car_Rental_Spring.model.Revenue;
import com.carrentalproject.Car_Rental_Spring.repository.RevenueRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RevenueService {

    private final RevenueRepository revenueRepository;

    public RevenueService(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    public List<Revenue> getAllRevenue() {
        return revenueRepository.findAll();
    }

    public Revenue addRevenue(double amount) {
        Revenue revenue = new Revenue();
        revenue.setTotalAmount(amount);
        return revenueRepository.save(revenue);
    }
}
