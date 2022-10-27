package com.example.tablerelationmaven;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String province;


    // map to person object and specify its name is person_id
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    // khong chi dinh joincolumns se dung class hien tai
    @JoinTable(name="address_person", joinColumns = @JoinColumn(name="address_id"),inverseJoinColumns = @JoinColumn(name="person_id"))
    private Collection<Person> persons;

}
