package com.carrentalproject.Car_Rental_Spring.service;



import com.carrentalproject.Car_Rental_Spring.model.Refund;
import com.carrentalproject.Car_Rental_Spring.repository.RefundRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RefundService {

    private final RefundRepository refundRepository;

    public RefundService(RefundRepository refundRepository) {
        this.refundRepository = refundRepository;
    }

    public Refund processReturn(Refund refund) {
        refund.setReturnDate(LocalDateTime.now());
        return refundRepository.save(refund);
    }
}

