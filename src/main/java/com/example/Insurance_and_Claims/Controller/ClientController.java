package com.example.Insurance_and_Claims.Controller;

import com.example.Insurance_and_Claims.Dto.LoginDto;
import com.example.Insurance_and_Claims.Model.Beneficiary;
import com.example.Insurance_and_Claims.Model.Client;
import com.example.Insurance_and_Claims.Response.LoginMessage;
import com.example.Insurance_and_Claims.Service.BeneficiaryService;
import com.example.Insurance_and_Claims.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
//@CrossOrigin("http://localhost:3000")
@RequestMapping("/client")

public class ClientController {

    @Autowired
    private final ClientService clientService;
    @Autowired
    BeneficiaryService beneficiaryService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(path="/save")
//    @PreAuthorize("hasRole('ADMIN')")
    public String saveClient(@RequestBody Client client)
    {
       return clientService.addClient(client);
    }

    @PostMapping(path="/login")
    public ResponseEntity<?> loginClient(@RequestBody LoginDto loginDto)
    {
        LoginMessage loginMessage=clientService.loginClient(loginDto);
        return ResponseEntity.ok(loginMessage);
    }

    @GetMapping(path = "/view")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<Client>findAllClient(){
        return clientService.findAllClient();
    }

    @GetMapping(path = "/find/firstname")
    public List<Client>findClientByFirstname(@RequestParam String firstname){
        return clientService.findClientByFirstname(firstname);
    }
    @GetMapping(path = "/find/keyword")
    public List<Client>findClientByKeyword(@RequestParam String firstname){
        return clientService.findClientByKeyword(firstname);
    }
    @GetMapping(path = "/find/lastname")
    public List<Client>findClientByLastname(@RequestParam String lastname){
        return clientService.findClientByLastname(lastname);
    }
    @GetMapping(path = "/find/gender")
    public List<Client>findClientByGender(@RequestParam String gender){
        return clientService.findClientByGender(gender);
    }

    @GetMapping(path = "/{id}")
//    @PreAuthorize("hasRole('USER')")
    public Optional<Client>findClientById(@PathVariable("id")Long id){
        return clientService.findById(id);
    }
//    @GetMapping(path = "/{id}")
//    public ClientDto getClientById(@PathVariable("id")Long id,@RequestParam(value = "clientData",required = false)boolean clientData){
//        return clientService.getById(id,clientData);
//    }

    @PutMapping(path = "update/{id}")
    public Client updateClient(@PathVariable ("id")Long id,@RequestBody Client client){
        client.setId(id);
        return clientService.updateClient(client);
    }
//    @PutMapping("/{id}/beneficiary/{beneficiary_id}")
//    Client assignBenefeciaryToClient(@PathVariable Long id, @PathVariable Long beneficiary_id)
//    {
//
//        Client client=clientService.findById(id).get();
//        Beneficiary beneficiary=beneficiaryService.findById(beneficiary_id).get();
//        client.enrollBeneficiary(beneficiary);
//        return clientService.saveClient(client);
//
//    }

//    @PutMapping("/{id}/insurance/{insurance_id}")
//    Client enrollClientToInsurance(@PathVariable Long id, @PathVariable Long insurance_id)
//    {
//        Client client=clientService.findById(id).get();
//        Insurance insurance= insuranceService.findById(insurance_id).get();
//        client.enrollInsurance(insurance);
//        return clientService.saveClient(client);
//
//    }

    @DeleteMapping(path="delete/{id}")
    public void deleteClient(@PathVariable("id")Long id){
        clientService.deleteClient(id);
    }


}
