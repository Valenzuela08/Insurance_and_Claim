package com.example.Insurance_and_Claims.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(name = "Supporting_Document")
public class SupportingDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="file_name")
    private String fileName;
    @Column(name="file_type")
    private String fileType;
    @Column(name="path")
    private String path;

    @Column(columnDefinition="bytea")
    private byte[] data;

    @ManyToOne
    @JoinColumn(name ="claim_id",referencedColumnName = "file_id")
    private FileClaim fileClaim;

    @JsonBackReference
    public FileClaim getFileClaim() {
        return fileClaim;
    }

    public void setFileClaim(FileClaim fileClaim) {
        this.fileClaim = fileClaim;
    }

    public SupportingDocument(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public SupportingDocument(long id, String path) {
        this.id = id;
        this.path = path;
    }

    public SupportingDocument() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public void enrollClaim(FileClaim fileClaim) {
        this.fileClaim=fileClaim;
    }

}
