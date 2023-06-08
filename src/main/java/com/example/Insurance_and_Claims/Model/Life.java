package com.example.Insurance_and_Claims.Model;
import com.example.Insurance_and_Claims.Model.Insurance;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.Data;

@Getter
@Setter
@Data
@Entity
@Table(name = "life_insurance_condition")
public class Life {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "life_id")
    private long life_id;

//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(
//            name = "life_insurance",
//            joinColumns = @JoinColumn(name = "life_id"),
//            inverseJoinColumns = @JoinColumn(name = "insurance_id"))
//    private Set<Insurance> enrolled_condition=new HashSet<>();
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "insurance_id",referencedColumnName = "insurance_id")
//    private Insurance insurance;

    @Column(name = "membership_year")
    private String years;

    @Column(name = "cause_of_death")
    private String cause;

    @Column(name = "amount")
    private Integer amt;


    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    @JsonBackReference
    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Life(long life_id, String years, String cause, Integer amt) {
        this.life_id = life_id;
        this.years = years;
        this.cause = cause;
        this.amt = amt;
    }

    public Life() {
    }

    public void assignInsurance(Insurance insurance) {
        this.insurance=insurance;
    }


//    public void assignInsurance(Insurance insurance) {
//    this.insurance=insurance;
//}
}
