package com.example.Insurance_and_Claims.Service.Implementation;

import com.example.Insurance_and_Claims.Response.LifeNotFoundException;
import com.example.Insurance_and_Claims.Repository.LifeRepository;
import com.example.Insurance_and_Claims.Service.LifeService;
import com.example.Insurance_and_Claims.Model.Life;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
@Service
public class LifeImplementation implements LifeService {

    @Autowired
    private LifeRepository lifeRepository;

    public LifeImplementation(LifeRepository lifeRepository) {
        this.lifeRepository = lifeRepository;
    }
    @Override
    public List<Life> findAllLife(String years) {

        List<Life> lifeList=new ArrayList<>();
        if(years==null)
        {
            lifeRepository.findAll()
                    .forEach(life->lifeList.add(life));
        }
        else
        {
           return lifeRepository.findAllByyears(years);
        }

        return lifeList;

    }



    @Override
    public Optional<Life> findById(Long life_id) {
        if (!lifeRepository.existsById(life_id)){
            throw new LifeNotFoundException(life_id);
        }
        return lifeRepository.findById(life_id);
    }

    @Override
    public Life saveLife(Life life) {
        return lifeRepository.save(life);
    }

    @Override
    public Life updateLife(Life life) {
        return lifeRepository.save(life);
    }

    @Override
    public void deleteLife(Long life_id) {
        if (!lifeRepository.existsById(life_id)){
            throw new LifeNotFoundException(life_id);
        }
        lifeRepository.deleteById(life_id);
    }
}
