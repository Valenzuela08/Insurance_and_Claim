package com.example.Insurance_and_Claims.Repository;

import com.example.Insurance_and_Claims.Model.FileClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories
@Repository
public interface FileClaimRepository extends JpaRepository<FileClaim,Long> {

}
