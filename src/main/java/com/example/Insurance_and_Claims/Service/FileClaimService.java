package com.example.Insurance_and_Claims.Service;

import com.example.Insurance_and_Claims.Model.FileClaim;

import java.util.List;
import java.util.Optional;


public interface FileClaimService {
    List<FileClaim> findAllFileClaim();
//    List<ClaimDto> findAllClaim();
    Optional<FileClaim> findById(Long file_id);
    FileClaim saveFileClaim(FileClaim fileClaim);
    FileClaim updateFileClaim(FileClaim fileClaim);
    void deleteFileClaim(Long file_id);

}
