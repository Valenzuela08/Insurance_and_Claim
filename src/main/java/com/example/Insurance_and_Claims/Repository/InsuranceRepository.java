package com.example.Insurance_and_Claims.Repository;

import com.example.Insurance_and_Claims.Model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface InsuranceRepository extends JpaRepository<Insurance,Long> {
   Optional<Insurance> findById(Long insurance_id);
}