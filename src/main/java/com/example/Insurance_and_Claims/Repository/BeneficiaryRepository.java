package com.example.Insurance_and_Claims.Repository;

import com.example.Insurance_and_Claims.Model.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary,Long> {
    Optional<Beneficiary> findById(Long beneficiary_id);
}
