package com.example.Insurance_and_Claims.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@Data
@Entity
@Table(name = "insurance")
public class Insurance {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="insurance_id")
    private long insurance_id;

    @Column(name="insurance_name")
    private String insurance_name;

    @Column(name="insurance_description")
    private String insurance_description;

    @Column(name="insurance_worth")
    private Integer worth;


//    @JsonIgnore
//    @OneToMany(mappedBy = "enrolled_condition")
//    private Life life;
//
//    @JsonIgnore
//    @ManyToMany(mappedBy = "enrolled_vehicle_condition")
//    private Set<Vehicle> enrolled_Vehicle_Insurance=new HashSet<>();
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "conditon_id",referencedColumnName = "life_id")


    @OneToMany(mappedBy = "insurance",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Life> condition;

    @JsonManagedReference
    public List<Life> getCondition() {
        return condition;
    }

    public void setCondition(List<Life> condition) {
        this.condition = condition;
    }




    @OneToMany(mappedBy = "insurance",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Vehicle> conditions;

    @JsonManagedReference
    public List<Vehicle> getConditions() {
        return conditions;
    }

    public void setConditions(List<Vehicle> conditions) {
        this.conditions = conditions;
    }




    //    @JsonIgnore
//    @ManyToMany
//    @JoinTable(
//            name = "vehicle_insurance",
//            joinColumns = @JoinColumn(name = "insurance_id"),
//            inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
//    private Set<Vehicle> enrolled_vehicle_condition=new HashSet<>();



    @JsonIgnoreProperties("enrolled_insurance")
    @ManyToMany
    @JoinTable(
            name = "insurance_enrolled",
            joinColumns = @JoinColumn(name = "insurance_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> enrolled_client;

    public List<Client> getEnrolled_client() {
        return enrolled_client;
    }

    public void setEnrolled_client(List<Client> enrolled_client) {
        this.enrolled_client = enrolled_client;
    }





    //    @JsonIgnore
//    @OneToMany(mappedBy = "insurance_id")
//    private Set<Life> enrolled_condition=new HashSet<>();
//    @JsonIgnore
//    @OneToMany(mappedBy = "insurance")
//    private Set<Life> life_insurance_condition=new HashSet<>();
//    @JsonIgnore
//    @OneToMany(mappedBy = "vehicle_id")
//    private Set<Vehicle> vehicle_insurance_condition=new HashSet<>();
//    @JsonIgnore
//    @ManyToMany(mappedBy = "enrolled_insurance")
//    private Set<Client> enrolled_Client=new HashSet<>();

    public Insurance(long insurance_id, String insurance_name, String insurance_description, Integer worth) {
        this.insurance_id = insurance_id;
        this.insurance_name = insurance_name;
        this.insurance_description = insurance_description;
        this.worth = worth;
    }

    public Insurance() {
    }

    public void enrollClient(Client client) {
        this.enrolled_client.add(client);
    }

//
//
//    public void setEnrolled_Life_Insurance(Set<Life> enrolled_Life_Insurance) {
//        this.enrolled_Life_Insurance = enrolled_Life_Insurance;
//    }

//    public void enrollLife(Life life) {
//        this.condition.add(life);
//    }

//    public void enrollVehicle(Vehicle vehicle) {
//        this.conditions.add(vehicle);
//    }

//    public void assignClient(Life life) {
//                this.life=life;
//    }

//    public void assignlife(Life life) {
//        this.life_insurance_condition=life_insurance_condition;
//    }


//    public void enrollClient(Client client) {
//        enrolled_Client.add(client);
//    }
}
