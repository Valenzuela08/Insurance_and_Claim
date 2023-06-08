package com.example.Insurance_and_Claims.Service.Implementation;

import com.example.Insurance_and_Claims.Response.InsuranceNotFoundException;
import com.example.Insurance_and_Claims.Repository.InsuranceRepository;
import com.example.Insurance_and_Claims.Service.InsuranceService;
import com.example.Insurance_and_Claims.Model.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Configuration
@Service
public class InsuranceImplementation implements InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    public InsuranceImplementation(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @Override
    public List<Insurance> findAllInsurance() {
        return insuranceRepository.findAll();
    }

    @Override
    public Optional<Insurance> findById(Long insurance_id) {
        if (!insuranceRepository.existsById(insurance_id)){
            throw new InsuranceNotFoundException(insurance_id);
        }
        return insuranceRepository.findById(insurance_id);
    }

    @Override
    public Insurance saveInsurance(Insurance insurance) {
        return insuranceRepository.save(insurance);
    }

    @Override
    public Insurance updateInsurance(Insurance insurance) {
        return insuranceRepository.save(insurance);
    }

    @Override
    public void deleteInsurance(Long insurance_id) {
        if (!insuranceRepository.existsById(insurance_id)){
            throw new InsuranceNotFoundException(insurance_id);
        }
        insuranceRepository.deleteById(insurance_id);
    }
}
