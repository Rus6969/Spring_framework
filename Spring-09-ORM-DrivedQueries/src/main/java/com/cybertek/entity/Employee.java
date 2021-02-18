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
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "salary")
    private Long salary;


    @ManyToOne
    // we need joincolumn here to specify to specify foreign name of deaprtment by defauilt it would create department_id but
    // since we are using data.sql to pump data there is name department( thats why we are using this annotation)
    @JoinColumn(name = "department")
    private Department departments;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;


}
