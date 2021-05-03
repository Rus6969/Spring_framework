package com.cybertek.entity;

import com.cybertek.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "account_details")
@ToString
//class level when we run AIP in Json will see all fieled with values names address etc if I do not show information in payload, ignore unkown if someone wants catch hack api , it wll ignore unkonws
@JsonIgnoreProperties(value = {"state","postalCode"},ignoreUnknown = true)
public class Account extends BaseEntity {

    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    @Column(name = "postal_code")
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @OneToOne(mappedBy = "account")
    //In a Account api I do not want see any info related to User similar to @Jsonignore,  in serialization it will give san me output but in desirialization
    // wvalue will not be null it will pickup reference data
    @JsonBackReference
    private User user;


    public Account(String name, String address, String country, String state, String city, Integer age, String postalCode, UserRole role) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.state = state;
        this.city = city;
        this.age = age;
        this.postalCode = postalCode;
        this.role = role;
    }
}