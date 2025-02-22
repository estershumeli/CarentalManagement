package com.carrentalproject.Car_Rental_Spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "car")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private String bodyType;
    private int year;
    private String color;
    private int mileage;
    private double dailyRate;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    @JsonBackReference // ✅ Prevent infinite loop when fetching Branch
    private Branch branch;

    public enum Status {
        AVAILABLE, BOOKED, UNAVAILABLE
    }

    @Enumerated(EnumType.STRING)
    private Status status;


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }


}
