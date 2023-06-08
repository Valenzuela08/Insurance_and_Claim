package com.example.Insurance_and_Claims.Service;


import com.example.Insurance_and_Claims.Model.Vehicle;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public interface VehicleService {
    List<Vehicle> findAllVehicle();
    Optional<Vehicle> findById(Long id);
    Vehicle saveVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    void deleteVehicle(Long id);

}
