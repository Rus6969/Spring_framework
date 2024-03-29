package com.cybertek.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;


    // 1.in one to many we need create container one person needs to match many addresses  we need put it as a collection
    // 2. we do not need Cascade.All bc we are not saving through person we are saving through address class
    @OneToMany(mappedBy = "person")
    private List<Address> addresses;


   // case-1 not preferable
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="person_id")
//    private List<Address> addresses;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}