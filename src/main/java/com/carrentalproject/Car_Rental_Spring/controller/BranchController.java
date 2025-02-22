package com.carrentalproject.Car_Rental_Spring.controller;

import com.carrentalproject.Car_Rental_Spring.model.Branch;
import com.carrentalproject.Car_Rental_Spring.repository.BranchRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    private final BranchRepository branchRepository;

    public BranchController(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @GetMapping
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }
}

