package org.example.service;

import org.example.entity.Rental;
import org.example.repository.RentalRepository;
import org.example.repository.VehicleRepository;

public class RentalService {
    private RentalRepository rentalRepository;

    public RentalService() {
        this.rentalRepository = new RentalRepository();
    }

    public Rental add(Rental rental) {
        return rentalRepository.add(rental);
    }
    public Rental search(Long id) {
        return rentalRepository.search(id);
    }


}
