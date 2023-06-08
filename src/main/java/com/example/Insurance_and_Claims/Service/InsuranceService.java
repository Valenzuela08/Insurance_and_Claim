package com.example.Insurance_and_Claims.Service;

import com.example.Insurance_and_Claims.Model.Insurance;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public interface InsuranceService {

    List<Insurance> findAllInsurance();
    Optional<Insurance> findById(Long insurance_id);
    Insurance saveInsurance(Insurance insurance);
    Insurance updateInsurance(Insurance insurance);
    void deleteInsurance(Long insurance_id);
}
