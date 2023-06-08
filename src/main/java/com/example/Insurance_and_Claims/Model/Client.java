package com.example.Insurance_and_Claims.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="client_id")
    private long id;

    @Column(name="firstname")
    private String firstname;

    @Column(name="middlename")
    private String middlename;

    @Column(name="lastname")
    private String lastname;

    @Column(name="suffixname")
    private String suffixname;

    @Column(name="street")
    private String street;

    @Column(name="barangay")
    private String barangay;

    @Column(name="municipality")
    private String municipality;

    @Column(name="province")
    private String province;

    @Column(name="birthdate")
    private Date birthdate;

    @Column(name="mobilenumber")
    private String phonenumber;

    @Column(name="sex")
    private String gender;

    @Column(name="email")
    private String email;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

//    @Column(name="role")
//    private String role;




    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Dependent> dependents;

    @JsonManagedReference
    public List<Dependent> getDependents() {
        return dependents;
    }
    public void setDependents(List<Dependent> dependents) {
        this.dependents = dependents;
    }




    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Beneficiary> beneficiaries;

    @JsonManagedReference
    public List<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }
    public void setBeneficiaries(List<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }





    @JsonIgnoreProperties("enrolled_client")
    @ManyToMany(mappedBy = "enrolled_client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Insurance> enrolled_insurance;

    public List<Insurance> getEnrolled_insurance() {
        return enrolled_insurance;
    }
    public void setEnrolled_insurance(List<Insurance> enrolled_insurance) {
        this.enrolled_insurance = enrolled_insurance;
    }


    @JsonIgnoreProperties("clients")
    @ManyToMany(mappedBy = "clients",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<FileClaim> fileClaims;

    public List<FileClaim> getFileClaims() {
        return fileClaims;
    }
    public void setFileClaims(List<FileClaim> fileClaims) {
        this.fileClaims = fileClaims;
    }

    public Client(String firstname, String middlename, String lastname, String suffixname, String street, String barangay, String municipality, String province, Date birthdate, String phonenumber, String gender, String email, String username, String password) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.suffixname = suffixname;
        this.street = street;
        this.barangay = barangay;
        this.municipality = municipality;
        this.province = province;
        this.birthdate = birthdate;
        this.phonenumber = phonenumber;
        this.gender = gender;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", suffixname='" + suffixname + '\'' +
                ", street='" + street + '\'' +
                ", barangay='" + barangay + '\'' +
                ", municipality='" + municipality + '\'' +
                ", province='" + province + '\'' +
                ", birthdate=" + birthdate +
                ", phonenumber='" + phonenumber + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
//        public void enrollBeneficiary(Beneficiary beneficiary) {
//        this.beneficiaries=beneficiaries;
//    }

//    public void setEnrolled_Insurance(Set<Insurance> enrolled_Insurance) {
//        this.enrolled_Insurance = enrolled_Insurance;
//    }
//    public void enrollInsurance(Insurance insurance) {
//        this.enrolled_insurance.add(insurance);
//    }
}
