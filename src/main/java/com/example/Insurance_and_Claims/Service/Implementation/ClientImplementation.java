package com.example.Insurance_and_Claims.Service.Implementation;

import com.example.Insurance_and_Claims.Dto.LoginDto;
import com.example.Insurance_and_Claims.Model.Client;
import com.example.Insurance_and_Claims.Repository.ClientRepository;
import com.example.Insurance_and_Claims.Repository.InsuranceRepository;
import com.example.Insurance_and_Claims.Response.ClientNotFoundException;
import com.example.Insurance_and_Claims.Response.LoginMessage;
import com.example.Insurance_and_Claims.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Configuration
@Service

class ClientImplementation implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private InsuranceRepository insuranceRepository;

    //Add Or Register Client
//    @Override
//    public String addClient(ClientDto clientDto) {
//
//        Client client=new Client(
//                clientDto.getFirstname(),
//                clientDto.getMiddlename(),
//                clientDto.getLastname(),
//                clientDto.getSuffixname(),
//                clientDto.getStreet(),
//                clientDto.getBarangay(),
//                clientDto.getMunicipality(),
//                clientDto.getProvince(),
//                clientDto.getBirthdate(),
//                clientDto.getPhonenumber(),
//                clientDto.getGender(),
//                clientDto.getEmail(),
//                clientDto.getUsername(),
//               this.passwordEncoder.encode(clientDto.getPassword())
//        );
//        clientRepository.save(client);
//        return client.getFirstname();
//    }

    @Override
    public String addClient(Client client) {
        Optional<Client> client1=clientRepository.findByUsername(client.getUsername());
        if (client1.isPresent()){
            return "Username already Exist";
        }else {
            client.setPassword(passwordEncoder.encode(client.getPassword()));
            clientRepository.save(client);
            return "User Added successfully";
        }
    }

    //Login
    @Override
    public LoginMessage loginClient(LoginDto loginDto) {
        String msg="";
        Optional<Client> client1=clientRepository.findByUsername(loginDto.getUsername());
        if (client1!=null){
            String password=loginDto.getPassword();
            String encodedPassword=client1.get().getPassword();
            Boolean isPwdRight=passwordEncoder.matches(password,encodedPassword);
            if (isPwdRight){
                Optional<Client>client=clientRepository.findOneByUsernameAndPassword(loginDto.getUsername(), encodedPassword);
                if (client.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {

                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("Username not exits", false);
        }
    }

    //Client Repository Constructor
    public ClientImplementation(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    //View All Client
    @Override
    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    //Find Client By Firstname
    @Override
    public List<Client> findClientByFirstname(String firstname) {
        return clientRepository.findByFirstname(firstname);
    }

    //Find Client By Keyword
    @Override
    public List<Client> findClientByKeyword(String firstname) {
        return clientRepository.findByFirstnameContaining(firstname);
    }

    //Find Client By Lastname
    @Override
    public List<Client> findClientByLastname(String lastname) {
        return clientRepository.findByLastname(lastname);
    }

    //Find Client By Gender
    @Override
    public List<Client> findClientByGender(String gender) {
        return clientRepository.findByGender(gender);
    }

    //Find Client by Id
    @Override
    public Optional<Client> findById(Long id) {
        if (!clientRepository.existsById(id)){
            throw new ClientNotFoundException(id);
        }
        return clientRepository.findById(id);

    }

//    @Override
//    public ClientDto getById(Long id, boolean clientData) {
//        Client client;
//        List<Insurance> insurances = null;
//        client = clientRepository.getById(id);
//        if (clientData)
//        {
//            insurances=insuranceRepository.findAllById(id);
//        }
//            ClientDto clientDto = new ClientDto();
//            clientDto.setId(client.getId());
//            clientDto.setFirstname(client.getFirstname());
//            clientDto.setMiddlename(client.getMiddlename());
//            clientDto.setLastname(client.getLastname());
//            clientDto.setSuffixname(client.getSuffixname());
//            clientDto.setStreet(client.getStreet());
//            clientDto.setBarangay(client.getBarangay());
//            clientDto.setMunicipality(client.getMunicipality());
//            clientDto.setProvince(client.getProvince());
//            clientDto.setBirthdate(client.getBirthdate());
//            clientDto.setPhonenumber(client.getPhonenumber());
//            clientDto.setGender(client.getGender());
//            clientDto.setEmail(client.getEmail());
//            clientDto.setUsername(client.getUsername());
//
//            List<InsuranceDto> insuranceDtoList = new ArrayList<>();
//            if (insurances!=null) {
//                for (Insurance insurance : insurances) {
//                    InsuranceDto insuranceDto = new InsuranceDto();
//                    insuranceDto.setId(insurance.getId());
//                    insuranceDto.setInsurance_name(insurance.getInsurance_name());
//                    insuranceDto.setInsurance_desription(insurance.getInsurance_desription());
//                    insuranceDto.setWorth(insurance.getWorth());
//
//                    insuranceDtoList.add(insuranceDto);
//                }
//                clientDto.setInsurances(insuranceDtoList);
//            }
//        return clientDto;
//    }

    //Update Client
    @Override
    public Client updateClient(Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        return clientRepository.save(client);
    }

//    @Override
//    public Client addClient(Client client) {
//        return clientRepository.save(client);
//    }

    //Delete Client
    @Override
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)){
            throw new ClientNotFoundException(id);
        }
        clientRepository.deleteById(id);
    }


}
