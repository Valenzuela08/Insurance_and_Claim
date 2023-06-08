package com.example.Insurance_and_Claims.Controller;

import com.example.Insurance_and_Claims.Model.FileClaim;
import com.example.Insurance_and_Claims.Model.SupportingDocument;
import com.example.Insurance_and_Claims.Response.ResponseData;
import com.example.Insurance_and_Claims.Service.FileClaimService;
import com.example.Insurance_and_Claims.Service.SupportingDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/document")

public class SupportingDocumentController   {

    private SupportingDocumentService supportingDocumentService;

    @Autowired
    FileClaimService fileClaimService;

    public SupportingDocumentController(SupportingDocumentService supportingDocumentService) {
        this.supportingDocumentService = supportingDocumentService;
    }

    @PostMapping("/upload")
    public ResponseEntity<List<ResponseData>> uploadFile(@RequestPart("files") MultipartFile[] files) throws Exception {
        List<ResponseData> responseDataList = new ArrayList<>();

        for (MultipartFile file : files) {
            SupportingDocument supportingDocument = null;
            String downloadURL = "";

            supportingDocument = supportingDocumentService.saveSupportingDocument(file);
            downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/document/download/")
                    .path(String.valueOf(supportingDocument.getId()))
                    .toUriString();


            supportingDocument.setPath(downloadURL);
            supportingDocumentService.saveSupportingDocument(supportingDocument);

            ResponseData responseData = new ResponseData(
                    supportingDocument.getFileName(),
                    downloadURL,
                    file.getContentType()
            );

            responseDataList.add(responseData);
        }

        return ResponseEntity.ok(responseDataList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ResponseData> getDocumentDetails(@PathVariable("id") Long id) throws Exception {
        SupportingDocument document = supportingDocumentService.getSupportingDocument(id);
        if (document != null) {
            String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/document/download/")
                    .path(String.valueOf(document.getId()))
                    .toUriString();

            ResponseData responseData = new ResponseData(
                    document.getFileName(),
                    downloadURL,
                    document.getFileType()
            );

            return ResponseEntity.ok(responseData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @PostMapping("/upload")
//    public ResponseData uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
//
//        SupportingDocument supportingDocument=null;
//        String downloadURL="";
//        supportingDocument=supportingDocumentService.saveSupportingDocument(file);
//        downloadURL= ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/download/")
//                .path(String.valueOf(supportingDocument.getId()))
//                .toUriString();
//
//        return new ResponseData(supportingDocument.getFileName(),downloadURL,file.getContentType(),file.getSize());
//    }
//    @PostMapping("/uploadFiles")
//    public List<ResponseData> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(file ->uploadFile(file))
//                .collect(Collectors.toList());
//    }


    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long id) throws Exception {
        SupportingDocument supportingDocument=null;
        supportingDocument=supportingDocumentService.getSupportingDocument(id);
        return ResponseEntity.ok()
                .contentType(   MediaType.parseMediaType(supportingDocument.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "supportingDocument;filename=\""+supportingDocument.getFileName()+"\"")
                .body( new ByteArrayResource(supportingDocument.getData()));
    }

    @PutMapping("/{id}/claims/{file_id}")
    String enrollFileToDocument(@PathVariable Long file_id, @PathVariable Long id) throws Exception {
        SupportingDocument document= supportingDocumentService.getSupportingDocument(id);
        FileClaim fileClaim= fileClaimService.findById(file_id).get();
        document.enrollClaim(fileClaim);
        supportingDocumentService.saveSupportingDocument(document);
        return "Document Added to Claims Successfully";

    }

    @GetMapping("/all")
    public ResponseEntity<List<Object[]>> getFileNameAndPath() {
        List<Object[]> fileNameAndPathList = supportingDocumentService.getAllFileNameAndPath();
        return ResponseEntity.ok(fileNameAndPathList);
    }


//    public ResponseEntity<List<String>> getAllPaths() {
//        List<String> paths = supportingDocumentService.getAllDocumentPaths();
//        return ResponseEntity.ok(paths);
//    }
}
