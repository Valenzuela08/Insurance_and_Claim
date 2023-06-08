package com.example.Insurance_and_Claims.Controller;



import com.example.Insurance_and_Claims.Model.Client;
import com.example.Insurance_and_Claims.Model.FileClaim;
import com.example.Insurance_and_Claims.Service.ClientService;
import com.example.Insurance_and_Claims.Service.FileClaimService;
import com.example.Insurance_and_Claims.Service.SupportingDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/fileClaims")
@RestController
public class FileClaimController {

    @Autowired
    private FileClaimService fileClaimService;

    @Autowired
    ClientService clientService;

    @Autowired
    SupportingDocumentService supportingDocumentService;

    public FileClaimController(FileClaimService fileClaimService) {
        this.fileClaimService = fileClaimService;
    }

    @PostMapping("/add")
    public FileClaim saveDependent(@RequestBody FileClaim fileClaim){
        return fileClaimService.saveFileClaim(fileClaim);
    }
    @GetMapping(path = "/view")
    public List<FileClaim> findAllFileClaim(){
        return fileClaimService.findAllFileClaim();
    }

    //    public ResponseEntity<List<ClaimDto>> findAllClaim() {
//        List<ClaimDto> claimDtoList = fileClaimService.findAllClaim();
//        return ResponseEntity.ok(claimDtoList);
//    }

    @GetMapping(path = "/{file_id}")
    public Optional<FileClaim> findFileClaimById(@PathVariable("file_id")Long file_id){
        return fileClaimService.findById(file_id);
    }

    @PutMapping(path = "update/{file_id}")
    public FileClaim updateFileClaim(@PathVariable Long file_id,@RequestBody FileClaim fileClaim){
        fileClaim.setFile_id(file_id);
        return fileClaimService.updateFileClaim(fileClaim);
    }
    @DeleteMapping(path="delete/{file_id}")
    public void deleteFileClaim(@PathVariable("file_id")Long file_id){
        fileClaimService.deleteFileClaim(file_id);
    }

    @PutMapping("/{file_id}/client/{id}")
    FileClaim enrollFileToClient(@PathVariable Long file_id, @PathVariable Long id)
    {
        FileClaim fileClaim=fileClaimService.findById(file_id).get();
        Client client= clientService.findById(id).get();
        fileClaim.enrollClient(client);
        return fileClaimService.saveFileClaim(fileClaim);

    }

}
