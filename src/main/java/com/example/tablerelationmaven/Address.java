package com.example.tablerelationmaven;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String province;


    // map to person object and specify its name is person_id
    @OneToOne
    @JoinColumn(name="person_id")
    private Person person;


}
