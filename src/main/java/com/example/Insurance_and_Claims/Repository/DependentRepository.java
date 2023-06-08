package com.example.Insurance_and_Claims.Repository;

import com.example.Insurance_and_Claims.Model.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@EnableJpaRepositories
@Repository

public interface DependentRepository extends JpaRepository<Dependent,Long> {
    Optional<Dependent> findById(Long dependent_id);
}
