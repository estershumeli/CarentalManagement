package com.carrentalproject.Car_Rental_Spring.controller;

import com.carrentalproject.Car_Rental_Spring.model.Car;
import com.carrentalproject.Car_Rental_Spring.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    // ✅ Fetch only available and booked cars
    @GetMapping
    public List<Car> getAvailableCars() {
        return carService.getAvailableCars();
    }

    // ✅ Fetch car by ID
    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    // ✅ Add a new car
    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    // ✅ Update car status (Ensure unavailable cars can't be booked)
    @PutMapping("/{carId}/status")
    public Car updateCarStatus(@PathVariable Long carId, @RequestParam Car.Status status) {
        return carService.updateCarStatus(carId, status);
    }
}



