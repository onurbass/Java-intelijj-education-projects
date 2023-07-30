package org.example.controller;

import org.example.entity.Rental;
import org.example.repository.RentalRepository;
import org.example.service.RentalService;

public class RentalController {
    private RentalService rentalService;

    public RentalController() {
        this.rentalService = new RentalService();
    }
    public Rental add(Rental rental) {
        return rentalService.add(rental);
    }
    public Rental search(Long id) {
        return rentalService.search(id);
    }
}
