package com.herbalife;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "persons")
public class Person extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private int age;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private List<Dog> dogs;

}
