package com.cybertek.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private Long studentID;
    private String firstName;
    private String lastName;
    private String email;

}
