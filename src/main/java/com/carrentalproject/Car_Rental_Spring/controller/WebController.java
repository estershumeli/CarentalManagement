package com.carrentalproject.Car_Rental_Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {


        @GetMapping("/")
        public String home() {
            return "index"; // ✅ Returns index.html from templates
        }

        @GetMapping("/cars")
        public String cars() {
            return "cars"; // ✅ Returns cars.html from templates
        }
    }



