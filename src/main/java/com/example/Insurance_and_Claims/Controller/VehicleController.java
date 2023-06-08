package com.example.Insurance_and_Claims.Controller;

import com.example.Insurance_and_Claims.Model.Insurance;
import com.example.Insurance_and_Claims.Model.Vehicle;
import com.example.Insurance_and_Claims.Service.InsuranceService;
import com.example.Insurance_and_Claims.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    public VehicleService vehicleService;
    @Autowired
    public InsuranceService insuranceService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    @PostMapping(path = "/save")
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.saveVehicle(vehicle);
    }
    @GetMapping(path = "/view")
    public List<Vehicle> findAllVehicle(){
        return vehicleService.findAllVehicle();
    }

    @GetMapping(path = "/view/{vehicle_id}")
    public Optional<Vehicle> findVehicleById(@PathVariable("vehicle_id")Long vehicle_id){
        return vehicleService.findById(vehicle_id);
    }

    @PutMapping(path = "update/{vehicle_id}")
    public Vehicle updateVehicle(@PathVariable Long vehicle_id,@RequestBody Vehicle vehicle){
        vehicle.setVehicle_id(vehicle_id);
        return vehicleService.updateVehicle(vehicle);
    }
    @PutMapping("/{insurance_id}/condition/{vehicle_id}")
    Vehicle assignVehicleConditionToInsurance(@PathVariable Long vehicle_id, @PathVariable Long insurance_id)
    {
        Vehicle vehicle=vehicleService.findById(vehicle_id).get();
        Insurance insurance= insuranceService.findById(insurance_id).get();
        vehicle.assignInsurance(insurance);
        return vehicleService.saveVehicle(vehicle);
    }

    @DeleteMapping(path="delete/{vehicle_id}")
    public void deleteVehicle(@PathVariable("vehicle_id")Long vehicle_id){
        vehicleService.deleteVehicle(vehicle_id);
    }
}
