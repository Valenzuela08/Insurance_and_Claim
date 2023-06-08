package com.example.Insurance_and_Claims.Service.Implementation;


import com.example.Insurance_and_Claims.Model.FileClaim;
import com.example.Insurance_and_Claims.Repository.FileClaimRepository;
import com.example.Insurance_and_Claims.Service.FileClaimService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileClaimImplementation implements FileClaimService {

    private FileClaimRepository fileClaimRepository;

    public FileClaimImplementation(FileClaimRepository fileClaimRepository) {
        this.fileClaimRepository = fileClaimRepository;
    }


    @Override
    public List<FileClaim> findAllFileClaim() {
        return fileClaimRepository.findAll();
    }

//    @Override
//    public List<ClaimDto> findAllClaim() {
//        List<FileClaim> fileClaims = fileClaimRepository.findAll();
//        List<ClaimDto> claimDtoList = new ArrayList<>();
//
//        for (FileClaim fileClaim : fileClaims) {
//            ClaimDto claimDto=new ClaimDto();
//            claimDto.setFile_id(fileClaim.getFile_id());
//            claimDto.setFirstname(fileClaim.getFirstname());
//            claimDto.setMiddlename(fileClaim.getMiddlename());
//            claimDto.setLastname(fileClaim.getLastname());
//            claimDto.setSuffixname(fileClaim.getSuffixname());
//            claimDto.setGender(fileClaim.getGender());
//            claimDto.setPhonenumber(fileClaim.getPhonenumber());
//            claimDto.setRelationship(fileClaim.getRelationship());
//            List<String> document_path=fileClaim.getSupportingDocuments().stream()
//                    .map(SupportingDocument::getPath)
//                    .collect(Collectors.toList());
//            claimDto.setDocument_path(document_path);
//            claimDtoList.add(claimDto);
//
//    }
//        return claimDtoList;
//    }

    @Override
    public Optional<FileClaim> findById(Long file_id) {
        return fileClaimRepository.findById(file_id);
    }

    @Override
    public FileClaim saveFileClaim(FileClaim fileClaim) {
        return fileClaimRepository.save(fileClaim);
    }

    @Override
    public FileClaim updateFileClaim(FileClaim fileClaim) {
        return fileClaimRepository.save(fileClaim);
    }

    @Override
    public void deleteFileClaim(Long file_id) {
        fileClaimRepository.deleteById(file_id);
    }
}
