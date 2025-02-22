
package com.carrentalproject.Car_Rental_Spring.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import com.carrentalproject.Car_Rental_Spring.model.Reservation;
import com.carrentalproject.Car_Rental_Spring.model.Car;
import com.carrentalproject.Car_Rental_Spring.repository.ReservationRepository;
import com.carrentalproject.Car_Rental_Spring.repository.CarRepository;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final CarRepository carRepository;

    public ReservationService(ReservationRepository reservationRepository, CarRepository carRepository) {
        this.reservationRepository = reservationRepository;
        this.carRepository = carRepository;
    }

    // ✅ Fetch all reservations
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // ✅ Create a new reservation
    public Reservation createReservation(Reservation reservation) {
        Car car = reservation.getCar();

        // ✅ Prevent past-date reservations
        if (reservation.getStartDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Start date cannot be in the past.");
        }

        if (car.getStatus() == Car.Status.AVAILABLE) {
            long days = ChronoUnit.DAYS.between(reservation.getStartDate(), reservation.getEndDate());
            double totalCost = days * car.getDailyRate();

            reservation.setTotalAmount(totalCost);
            car.setStatus(Car.Status.BOOKED);
            carRepository.save(car);

            return reservationRepository.save(reservation);
        }
        throw new RuntimeException("Car is not available for booking.");
    }


    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        long daysBeforeStart = ChronoUnit.DAYS.between(LocalDate.now(), reservation.getStartDate());
        double refundAmount = 0.0;

        // ✅ Apply 80% refund if canceled 2+ days before start date
        if (daysBeforeStart >= 2) {
            refundAmount = reservation.getTotalAmount() * 0.80;
            System.out.println("Refund processed: $" + refundAmount);
        }

        // ✅ Mark car as available
        reservation.getCar().setStatus(Car.Status.AVAILABLE);
        carRepository.save(reservation.getCar());

        reservationRepository.delete(reservation);
    }
}
