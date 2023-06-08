package com.example.Insurance_and_Claims.Service;

import com.example.Insurance_and_Claims.Model.Beneficiary;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public interface BeneficiaryService {

    List<Beneficiary> findAllBeneficiary();
    Optional<Beneficiary> findById(Long beneficiary_id);
    Beneficiary saveBeneficiary(Beneficiary beneficiary);
    Beneficiary updateBeneficiary(Beneficiary beneficiary);
    void deleteBeneficiary(Long beneficiary_id);
}
