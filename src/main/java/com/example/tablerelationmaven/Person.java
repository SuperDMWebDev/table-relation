package com.example.tablerelationmaven;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @ManyToMany(mappedBy = "persons")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Address> address;
}
