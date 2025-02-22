package com.carrentalproject.Car_Rental_Spring.service;

import com.carrentalproject.Car_Rental_Spring.model.Rental;
import com.carrentalproject.Car_Rental_Spring.repository.RentalRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental createRental(Rental rental) {
        return rentalRepository.save(rental);
    }
}

