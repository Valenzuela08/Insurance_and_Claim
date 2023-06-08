package com.example.Insurance_and_Claims.Controller;

import com.example.Insurance_and_Claims.Service.LifeService;
import com.example.Insurance_and_Claims.Model.Insurance;
import com.example.Insurance_and_Claims.Model.Life;
import com.example.Insurance_and_Claims.Service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/life")
public class LifeController {

    @Autowired
    public LifeService lifeService;
    @Autowired
    public InsuranceService insuranceService;

    public LifeController(LifeService lifeService) {
        this.lifeService = lifeService;
    }
    @PostMapping(path = "/save")
    public Life saveLife(@RequestBody Life life){
        return lifeService.saveLife(life);
    }
    @GetMapping(path = "/view")
    public List<Life> findAllLife(@RequestParam(value = "years",required = false) String years){
        return lifeService.findAllLife(years);
    }

    @GetMapping(path = "/view/{life_id}")
    public Optional<Life> findById(@PathVariable("life_id")Long life_id){
        return lifeService.findById(life_id);
    }

    @PutMapping(path = "update/{life_id}")
    public Life updateLife(@PathVariable Long life_id,@RequestBody Life life){
        life.setLife_id(life_id);
        return lifeService.updateLife(life);
    }
    @PutMapping("/{insurance_id}/condition/{life_id}")Life assignLifeConditionToInsurance(@PathVariable Long life_id,@PathVariable Long insurance_id)
    {
        Life life=lifeService.findById(life_id).get();
        Insurance insurance= insuranceService.findById(insurance_id).get();
        life.assignInsurance(insurance);
        return lifeService.saveLife(life);

    }

//    @PutMapping("/{life_id}/insurance/{insurance_id}")
//    Life assignLifeConditionToInsurance(
//            @PathVariable Long life_id,
//            @PathVariable Long insurance_id)
//    {
//        Life life=lifeService.findById(life_id).get();
//        Insurance insurance= insuranceService.findById(insurance_id).get();
//        life.assignInsurance(insurance);
//        return lifeService.saveLife(life);
//
//    }

    @DeleteMapping(path="delete/{life_id}")
    public void deleteLife(@PathVariable("life_id")Long life_id){
        lifeService.deleteLife(life_id);
    }
}
