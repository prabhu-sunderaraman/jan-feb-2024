package com.herbalife;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @Column
    private String model;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person owner;


    //NEVER DO THIS
//    @Column(name = "person_id")
//    private int personId;


}
