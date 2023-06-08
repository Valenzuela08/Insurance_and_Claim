package com.example.Insurance_and_Claims.Controller;


import com.example.Insurance_and_Claims.Model.Client;
import com.example.Insurance_and_Claims.Model.Dependent;
import com.example.Insurance_and_Claims.Service.ClientService;
import com.example.Insurance_and_Claims.Service.DependentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dependent")
public class DependentController {

    @Autowired
    private DependentService dependentService;

    @Autowired
    ClientService clientService;

    public DependentController(DependentService dependentService) {
        this.dependentService = dependentService;
    }

    @PostMapping("/add")
    public Dependent saveDependent(@RequestBody Dependent dependent){
        return dependentService.saveDependent(dependent);
    }
    @GetMapping(path = "/view")
    public List<Dependent> findAllDependent(){
        return dependentService.findAllDependent();
    }

    @GetMapping(path = "/{dependent_id}")
    public Optional<Dependent> findDependentById(@PathVariable("dependent_id")Long dependent_id){
        return dependentService.findById(dependent_id);
    }

    @PutMapping(path = "update/{dependent_id}")
    public Dependent updateDependent(@PathVariable Long dependent_id,@RequestBody Dependent dependent){
        dependent.setDependent_id(dependent_id);
        return dependentService.updateDependent(dependent);
    }
    @DeleteMapping(path="delete/{dependent_id}")
    public void deleteDependent(@PathVariable("dependent_id")Long dependent_id){
        dependentService.deleteDependent(dependent_id);
    }

    @PutMapping("/{dependent_id}/client/{id}")
    Dependent enrollDependentToClient(@PathVariable Long dependent_id, @PathVariable Long id)
    {
        Dependent dependent=dependentService.findById(dependent_id).get();
        Client client= clientService.findById(id).get();
        dependent.enrollClient(client);
        return dependentService.saveDependent(dependent);

    }

}
