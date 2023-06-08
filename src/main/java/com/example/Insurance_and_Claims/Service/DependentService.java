package com.example.Insurance_and_Claims.Service;

import com.example.Insurance_and_Claims.Model.Dependent;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;
@Configuration

public interface DependentService {
    List<Dependent> findAllDependent();
    Optional<Dependent> findById(Long dependent_id);
    Dependent saveDependent(Dependent dependent);
    Dependent updateDependent(Dependent dependent);
    void deleteDependent(Long dependent_id);
}
