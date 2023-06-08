package com.example.Insurance_and_Claims.Service.Implementation;

import com.example.Insurance_and_Claims.Model.Vehicle;
import com.example.Insurance_and_Claims.Response.VehicleNotFoundException;
import com.example.Insurance_and_Claims.Repository.VehicleRepository;
import com.example.Insurance_and_Claims.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Configuration
@Service
public class VehicleImplementation implements VehicleService {

    @Autowired
    public VehicleRepository vehicleRepository;

    public VehicleImplementation(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> findAllVehicle() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        if (!vehicleRepository.existsById(id)){
            throw new VehicleNotFoundException(id);
        }
        return vehicleRepository.findById(id);
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)){
            throw new VehicleNotFoundException(id);
        }
        vehicleRepository.deleteById(id);
    }
}
