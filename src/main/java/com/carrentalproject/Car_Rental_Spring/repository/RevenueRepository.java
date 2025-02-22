

package com.carrentalproject.Car_Rental_Spring.repository;

import com.carrentalproject.Car_Rental_Spring.model.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Long> {

}

