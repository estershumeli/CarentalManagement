package com.carrentalproject.Car_Rental_Spring.repository;

import com.carrentalproject.Car_Rental_Spring.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    // ✅ Fetch only cars that are not UNAVAILABLE
    List<Car> findByStatusNot(Car.Status status);
}




