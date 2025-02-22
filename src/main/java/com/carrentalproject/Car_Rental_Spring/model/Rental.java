package com.carrentalproject.Car_Rental_Spring.model;




import jakarta.persistence.*;
import lombok.*;

import java.util.List;

    @Entity
    @Table(name = "rental")
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public class Rental {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String domain;
        private String contactAddress;
        private String owner;
        private String logotype;

        @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
        private List<Branch> branches;
    }


