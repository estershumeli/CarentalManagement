package com.carrentalproject.Car_Rental_Spring.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.carrentalproject.Car_Rental_Spring.service.RefundService;
import com.carrentalproject.Car_Rental_Spring.model.Refund;

@RestController
@RequestMapping("/api/refunds")
public class RefundController {

    private final RefundService refundService;

    public RefundController(RefundService refundService) {
        this.refundService = refundService;
    }

    @PostMapping
    public Refund returnCar(@RequestBody Refund refund) {
        return refundService.processReturn(refund);
    }
}

