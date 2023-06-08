package com.example.Insurance_and_Claims.Service;

import com.example.Insurance_and_Claims.Model.Life;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public interface LifeService {

    //List<Life> findAllLife(Set<String>years);

    //List<Life> findAllLife();

    List<Life> findAllLife(String years);
    Optional<Life> findById(Long life_id);
    Life saveLife(Life life);
    Life updateLife(Life life);
    void deleteLife(Long life_id);
}
