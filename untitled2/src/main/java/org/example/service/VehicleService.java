package org.example.service;

import org.example.entity.Enums.EVehicleStatus;
import org.example.entity.Vehicle;
import org.example.repository.VehicleRepository;

import java.util.List;

public class VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleService() {
        this.vehicleRepository = new VehicleRepository();
    }
    public Vehicle add(Vehicle vehicle) {
        return vehicleRepository.add(vehicle);
    }
    public Vehicle search(Long id) {
        return vehicleRepository.search(id);
    }
    public List<Vehicle> availableOrRentedVehicles(EVehicleStatus eVehicleStatus) {
        return vehicleRepository.availableOrRentedVehicles(eVehicleStatus);
    }
    public List<Vehicle> rentedVehiclesByPersonId(Long id) {
        return vehicleRepository.rentedVehiclesByPersonId(id);
    }
}
