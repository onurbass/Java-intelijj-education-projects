package org.example.controller;

import org.example.entity.Enums.EVehicleStatus;
import org.example.entity.Vehicle;
import org.example.repository.VehicleRepository;
import org.example.service.VehicleService;

import java.util.List;

public class VehicleController {
    private VehicleService vehicleService;

    public VehicleController() {
        this.vehicleService = new VehicleService();
    }

    public Vehicle add(Vehicle vehicle) {
        return vehicleService.add(vehicle);
    }

    public Vehicle search(Long id) {
        return vehicleService.search(id);
    }

    public List<Vehicle> availableOrRentedVehicles(EVehicleStatus eVehicleStatus) {
        return vehicleService.availableOrRentedVehicles(eVehicleStatus);
    }

    public List<Vehicle> rentedVehiclesByPersonId(Long id) {
        return vehicleService.rentedVehiclesByPersonId(id);
    }

}
