package com.cybertek.entity;

import com.cybertek.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
public class Employee extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int salary;
// we need cascade to create realtionship and what to do with department object (should we add it , merge , or detach)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    // @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    //example above means whenever I do actions in employeetable same actions will be done in department table
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="region_id")
    private Region region;

    public Employee(String firstName, String lastName, String email, LocalDate hireDate, Gender gender, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.gender = gender;
        this.salary = salary;
    }
}