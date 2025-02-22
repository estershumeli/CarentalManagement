package com.carrentalproject.Car_Rental_Spring.services.customer;

import com.carrentalproject.Car_Rental_Spring.dto.BookACarDto;
import com.carrentalproject.Car_Rental_Spring.dto.CarDto;

import javax.swing.*;
import java.util.List;

public interface CustomerService {
    List<CarDto> getAllCars();

    boolean bookACar(BookACarDto bookACarDto);
    CarDto getCarById(Long carId);

    List<BookACarDto>getBookingsByUserId(Long userId);

}
