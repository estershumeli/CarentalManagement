package com.carrentalproject.Car_Rental_Spring.model;



import jakarta.persistence.*;
import lombok.*;

    @Entity
    @Table(name = "employee")
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String firstName;
        private String lastName;

        @Enumerated(EnumType.STRING)
        private Position position;

        @ManyToOne
        @JoinColumn(name = "branch_id")
        private Branch branch;

        public enum Position {
            EMPLOYEE, MANAGER
        }
    }


