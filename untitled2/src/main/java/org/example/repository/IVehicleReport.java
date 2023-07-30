package org.example.repository;

import org.example.entity.Enums.EVehicleStatus;
import org.example.entity.Vehicle;

import java.util.List;

public interface IVehicleReport {
    List<Vehicle> availableOrRentedVehicles(EVehicleStatus eVehicleStatus);

    List<Vehicle> rentedVehiclesByPersonId(Long id);
}
