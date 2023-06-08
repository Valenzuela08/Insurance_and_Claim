package com.example.Insurance_and_Claims.Service.Implementation;

import com.example.Insurance_and_Claims.Repository.BeneficiaryRepository;
import com.example.Insurance_and_Claims.Service.BeneficiaryService;
import com.example.Insurance_and_Claims.Model.Beneficiary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Configuration
@Service
public class BeneficiaryImplementation implements BeneficiaryService {

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    public BeneficiaryImplementation(BeneficiaryRepository beneficiaryRepository) {
        this.beneficiaryRepository = beneficiaryRepository;
    }

    @Override
    public List<Beneficiary> findAllBeneficiary() {
        return beneficiaryRepository.findAll();
    }

    @Override
    public Optional<Beneficiary> findById(Long beneficiary_id) {
        return beneficiaryRepository.findById(beneficiary_id);
    }

    @Override
    public Beneficiary saveBeneficiary(Beneficiary beneficiary) {
        return beneficiaryRepository.save(beneficiary);
    }

    @Override
    public Beneficiary updateBeneficiary(Beneficiary beneficiary) {
        return beneficiaryRepository.save(beneficiary);
    }

    @Override
    public void deleteBeneficiary(Long beneficiary_id) {
        beneficiaryRepository.deleteById(beneficiary_id);
    }
}
