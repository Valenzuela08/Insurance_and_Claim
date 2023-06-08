package com.example.Insurance_and_Claims.Service;

import com.example.Insurance_and_Claims.Dto.LoginDto;
import com.example.Insurance_and_Claims.Model.Client;
import com.example.Insurance_and_Claims.Response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Configuration

public interface ClientService {
    @Autowired
    String addClient(Client client);

    LoginMessage loginClient(LoginDto loginDto);
    List<Client>findAllClient();
    List<Client>findClientByFirstname(String firstname);
    List<Client>findClientByKeyword(String firstname);
    List<Client>findClientByLastname(String lastname);
    List<Client>findClientByGender(String gender);
    Optional<Client> findById(Long id);
    Client updateClient(Client client);
    void deleteClient(Long id);
//    ClientDto getById(Long id,boolean clientData);
//    Client saveClient(Client client);


//    Client addClient(Client client);
}
