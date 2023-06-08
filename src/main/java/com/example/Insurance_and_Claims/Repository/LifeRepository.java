package com.example.Insurance_and_Claims.Repository;

import com.example.Insurance_and_Claims.Model.Life;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface LifeRepository extends JpaRepository<Life,Long> {
    List<Life>findAllByyears(String years);
}
