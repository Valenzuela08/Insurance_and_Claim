package com.example.Insurance_and_Claims.Controller;

import com.example.Insurance_and_Claims.Service.InsuranceService;
import com.example.Insurance_and_Claims.Model.Client;
import com.example.Insurance_and_Claims.Model.Insurance;
import com.example.Insurance_and_Claims.Service.ClientService;
import com.example.Insurance_and_Claims.Service.LifeService;
import com.example.Insurance_and_Claims.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    @Autowired
    private final InsuranceService insuranceService;
    @Autowired
    ClientService clientService;
    @Autowired
    LifeService lifeService;
    @Autowired
    VehicleService vehicleService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }
    @PostMapping(path = "/save")
    public Insurance saveInsurance(@RequestBody Insurance insurance){
        return insuranceService.saveInsurance(insurance);
    }
    @GetMapping(path = "/view")
    public List<Insurance> findAllInsurance(){
        return insuranceService.findAllInsurance();
    }

    @GetMapping(path = "/{insurance_id}")
    public Optional<Insurance> findInsuranceById(@PathVariable("insurance_id")Long insurance_id){
        return insuranceService.findById(insurance_id);
    }

    @PutMapping(path = "update/{insurance_id}")
    public Insurance updateInsurance(@PathVariable Long insurance_id,@RequestBody Insurance insurance){
        insurance.setInsurance_id(insurance_id);
        return insuranceService.updateInsurance(insurance);
    }
    @PutMapping("/{insurance_id}/client/{id}")
    Insurance enrollClientToInsurance(@PathVariable Long insurance_id, @PathVariable Long id)
    {
        Insurance insurance=insuranceService.findById(insurance_id).get();
        Client client= clientService.findById(id).get();
        insurance.enrollClient(client);
        return insuranceService.saveInsurance(insurance);

    }
//    @PutMapping("/{insurance_id}/life/{life_id}")Insurance assignLifeConditionToInsurance(@PathVariable Long insurance_id,@PathVariable Long life_id)
//    {
//
//        Insurance insurance=insuranceService.findById(insurance_id).get();
//        Life life= lifeService.findById(life_id).get();
//        insurance.enrollLife(life);
//        return insuranceService.saveInsurance(insurance);
//
//    }
//    @PutMapping("/{insurance_id}/vehicle/{vehicle_id}")Insurance assignVehicleConditionToInsurance(@PathVariable Long insurance_id,@PathVariable Long vehicle_id)
//    {
//
//        Insurance insurance=insuranceService.findById(insurance_id).get();
//        Vehicle vehicle= vehicleService.findById(vehicle_id).get();
//        insurance.enrollVehicle(vehicle);
//        return insuranceService.saveInsurance(insurance);
//
//    }

//    @PutMapping("/{insurance_id}/life/{life_id}")
//    Insurance assignLifeConditionToInsurance(@PathVariable Long insurance_id, @PathVariable Long life_id)
//    {
//        Insurance insurance=insuranceService.findById(insurance_id).get();
//        Life life= lifeService.findById(life_id).get();
//        insurance.assignlife(life);
//        return insuranceService.saveInsurance(insurance);
//    }
//    @PutMapping("/{insurance_Id}/client/{Id}")
//    Insurance enrollInsuranceToClient(@PathVariable Long insurance_id, @PathVariable Long id)
//    {
//        Insurance insurance=insuranceService.findById(insurance_id).get();
//        Client client= clientService.findById(id).get();
//        insurance.enrollClient(client);
//        return insuranceService.saveInsurance(insurance );
//
//    }

    @DeleteMapping(path="delete/{insurance_id}")
    public void deleteInsurance(@PathVariable("insurance_id")Long insurance_id){
        insuranceService.deleteInsurance(insurance_id);
    }
}
