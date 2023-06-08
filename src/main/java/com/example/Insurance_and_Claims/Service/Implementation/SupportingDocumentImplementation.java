package com.example.Insurance_and_Claims.Service.Implementation;

import com.example.Insurance_and_Claims.Model.SupportingDocument;
import com.example.Insurance_and_Claims.Repository.SupportingDocumentRepository;
import com.example.Insurance_and_Claims.Service.SupportingDocumentService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class SupportingDocumentImplementation implements SupportingDocumentService {


    private final SupportingDocumentRepository supportingDocumentRepository;
    private List<SupportingDocument> ResponseData;

    public SupportingDocumentImplementation(SupportingDocumentRepository supportingDocumentRepository) {
        this.supportingDocumentRepository = supportingDocumentRepository;
    }

    @Override
    public SupportingDocument saveSupportingDocument(MultipartFile file) throws Exception {
        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        try {
                if (fileName.contains("..")){
                    throw new Exception("Filename contains invalid path sequence"+fileName);

                }
                SupportingDocument supportingDocument= new SupportingDocument(fileName,
                        file.getContentType(),
                        file.getBytes());
                return supportingDocumentRepository.save(supportingDocument);
        }catch (IOException ex) {
            throw new Exception("Could not save File:" +fileName);
        }
    }

    @Override
    public SupportingDocument getSupportingDocument(Long id) throws Exception {
        return supportingDocumentRepository
                .findById(id)
                .orElseThrow(()->new Exception("File not found with ID:" +id));
    }


    @Override
    public Optional<SupportingDocument> findById(Long id) {
        return supportingDocumentRepository.findById(id);
    }



    @Override
    public SupportingDocument saveSupportingDocument(SupportingDocument supportingDocument) {
        return supportingDocumentRepository.save(supportingDocument);
    }

//    @Override
//    public List<String> getAllDocumentPaths() {
//        return supportingDocumentRepository.findAllPath();
//    }

    @Override
    public List<Object[]> getAllFileNameAndPath() {
        return supportingDocumentRepository.findAllFileNameAndPath();
    }

}
