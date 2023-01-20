package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
public class Department extends BaseEntity {

    private String department;
    private String division;
    // mapped do not consider me as an owner give ownership department where is joinn column Employee class line 31-36 name should match with line 36 ""department"
// mapped by annotation is used to avoid creation t foreign keys , also we place here employee to use bidirectorial connection giving ownership to line 33 in Employee class
    @OneToOne(mappedBy = "department")
    private Employee employee;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}