
package com.carrentalproject.Car_Rental_Spring.service;

import com.carrentalproject.Car_Rental_Spring.model.Car;
import com.carrentalproject.Car_Rental_Spring.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // ✅ Get only cars that are not UNAVAILABLE
    public List<Car> getAvailableCars() {
        return carRepository.findByStatusNot(Car.Status.UNAVAILABLE);
    }

    // ✅ Get a car by ID (Prevent UNAVAILABLE cars from being booked)
    public Optional<Car> getCarById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent() && car.get().getStatus() == Car.Status.UNAVAILABLE) {
            throw new RuntimeException("This car is unavailable.");
        }
        return car;
    }

    // ✅ Add a new car
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    // ✅ Update Car Status (Ensure unavailable cars cannot be booked)
    public Car updateCarStatus(Long carId, Car.Status newStatus) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        if (car.getStatus() == Car.Status.UNAVAILABLE && newStatus == Car.Status.BOOKED) {
            throw new RuntimeException("Cannot book an unavailable car.");
        }

        car.setStatus(newStatus);
        return carRepository.save(car);
    }
}
