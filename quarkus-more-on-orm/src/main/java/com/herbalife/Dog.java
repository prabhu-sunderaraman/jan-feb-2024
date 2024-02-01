package com.herbalife;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dogs")
public class Dog extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;


    //NEVER DO THIS
//    @Column(name = "person_id")
//    private int personId;


}
