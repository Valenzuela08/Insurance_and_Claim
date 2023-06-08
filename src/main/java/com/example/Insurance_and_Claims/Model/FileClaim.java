package com.example.Insurance_and_Claims.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "claim")
public class FileClaim implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="file_id")
    private long file_id;

    @Column(name="firstname")
    private String firstname;

    @Column(name="middlename")
    private String middlename;

    @Column(name="lastname")
    private String lastname;

    @Column(name="suffixname")
    private String suffixname;

    @Column(name="sex")
    private String gender;

    @Column(name="mobilenumber")
    private String phonenumber;

    @Column(name="relationship")
    private String relationship;


    @OneToMany(mappedBy = "fileClaim",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<SupportingDocument> supportingDocuments;

    @JsonManagedReference
    public List<SupportingDocument> getSupportingDocuments() {
        return supportingDocuments;
    }

    public void setSupportingDocuments(List<SupportingDocument> supportingDocuments) {
        this.supportingDocuments = supportingDocuments;
    }

    @JsonIgnoreProperties("fileClaims")
    @ManyToMany
    @JoinTable(
            name = "filed_claims",
            joinColumns = @JoinColumn(name = "claim_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }



    public FileClaim(long file_id, String firstname, String middlename, String lastname, String suffixname, String gender, String phonenumber, String relationship) {
        this.file_id = file_id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.suffixname = suffixname;
        this.gender = gender;
        this.phonenumber = phonenumber;
        this.relationship = relationship;
    }

    public FileClaim() {
    }

    public long getFile_id() {
        return file_id;
    }

    public void setFile_id(long file_id) {
        this.file_id = file_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSuffixname() {
        return suffixname;
    }

    public void setSuffixname(String suffixname) {
        this.suffixname = suffixname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public void enrollClient(Client client) {
        this.clients.add(client);
    }


}
