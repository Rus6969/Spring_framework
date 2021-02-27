package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@ToString
@NamedQuery(name = "Department.findRussellDepartmet",
query = "select d from Department d where d.division=?1")

// named queries regular sql query will directly communicate with DB
@NamedNativeQuery(name="Department.countAllDepartments",
query = "select * from  departments",
resultClass = Department.class)
// if we want return just number not a whole object we do not specify a whole class in result class
//@NamedNativeQuery(name="Department.countAllDepartments",
  //      query = "select coint(*) from  departments")
public class Department {
    @Id
    private String department;

    private  String division;
}
