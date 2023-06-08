package com.example.Insurance_and_Claims.Repository;

import com.example.Insurance_and_Claims.Model.SupportingDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface SupportingDocumentRepository extends JpaRepository<SupportingDocument,Long> {

//    @Query("SELECT s.path FROM SupportingDocument s")
//    List<String> findAllPath();

    @Query("SELECT s.fileName, s.path FROM SupportingDocument s")
    List<Object[]> findAllFileNameAndPath();
}
