package com.example.Insurance_and_Claims.Repository;


import com.example.Insurance_and_Claims.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findOneByUsernameAndPassword(String username, String password);
    //List<Insurance> findAllById(Long id);
    Optional<Client> findByUsername(String username);
    List <Client> findByFirstname(String firstname);
    List <Client> findByFirstnameContaining(String keyword);
    List <Client> findByLastname(String lastname);
    List <Client> findByGender(String gender);
}
