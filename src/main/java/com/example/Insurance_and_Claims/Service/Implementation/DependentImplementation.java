package com.example.Insurance_and_Claims.Service.Implementation;

import com.example.Insurance_and_Claims.Repository.DependentRepository;
import com.example.Insurance_and_Claims.Service.DependentService;
import com.example.Insurance_and_Claims.Model.Dependent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Configuration
@Service
public class DependentImplementation implements DependentService {

    @Autowired
    private DependentRepository dependentRepository;

    public DependentImplementation(DependentRepository dependentRepository) {
        this.dependentRepository = dependentRepository;
    }

    @Override
    public List<Dependent> findAllDependent() {
        return dependentRepository.findAll();
    }

    @Override
    public Optional<Dependent> findById(Long dependent_id) {
        return dependentRepository.findById(dependent_id);
    }

    @Override
    public Dependent saveDependent(Dependent dependent) {
        return dependentRepository.save(dependent);
    }

    @Override
    public Dependent updateDependent(Dependent dependent) {
        return dependentRepository.save(dependent);
    }

    @Override
    public void deleteDependent(Long dependent_id) {
        dependentRepository.deleteById(dependent_id);
    }
}
