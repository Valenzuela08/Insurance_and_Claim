package com.example.Insurance_and_Claims.Repository;

import com.example.Insurance_and_Claims.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
