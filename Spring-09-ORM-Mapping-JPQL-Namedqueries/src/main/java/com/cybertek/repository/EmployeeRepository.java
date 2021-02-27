package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT e FROM Employee e WHERE e.email = 'dtrail8@tamu.edu'")
    Employee getEmployeeDetail();

    @Query("select e.salary from Employee e where e.email = 'dtrail8@tamu.edu'")
    Integer getEmployeeSalary();

    // with parameters/  positional parameters
     // single bind parameter
    @Query("select e from Employee e where e.email = ?1")
    Optional<Employee>getEmployeeByEmail(String email);

    @Query("select e from Employee e where e.email=?1 and e.salary=?2")
    Employee getEmployeeByEmailAndSalary(String email, Integer salary);

    // single named parameter :
    @Query("select e from Employee  e where e.salary=:salary")
    Employee getEmployeeBySalary(@Param("salary") int salary);

    //multiple named parameters
    @Query("select e from Employee e where e.firstName=:name OR e.salary=:salary")
    List<Employee>getEmployeeByFirstNameOrSalary(@Param("name")String name,@Param("salary") int salary);

    //NOT equal
    @Query("select e from Employee e where e.salary <>?1")
    List<Employee>getEmployeeBySalaryNotEqual(int salary);


    //Like / Contains / StartsWith / Ends With
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> getEmployeeByFirstNameLike(String patter);

    //Less Than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> getEmployeeBySalaryLessThan(int salary);

    //Greater Than
    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> getEmployeeBySalaryGreaterThan(Integer salary);

    //Between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> getEmployeeBySalaryBetween(int salary1,int salary2);

    //Before
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> getEmployeeByHireDateBefore(LocalDate date);

    //Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> getEmployeeByEmailIsNull();

    //Not Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> getEmployeeByEmailIsNotNull();

    //Sort Salary in ascending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> getEmployeeBySalaryOrderByAsc();
    @Query("select e from Employee  e order by e.salary desc ")
    List<Employee>getEmployeeBySalaryOrderByDesc();

    // Native query direct through DB not ENTITY !!! ! we using name of db not Entity name
     @Query(value = "select * from Employees where salary = ?1",nativeQuery = true)
    List<Employee>rwdEmployeeBySalary(int salary);


     // to do mofifications like update delete etc for JPQL
    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email ='admin@email.com' WHERE e.id=:id")
    void updateEmployeeJPQL(@Param("id") Integer id);


    // to do modifications like update delete etc for SQL
    @Modifying
    @Transactional
    @Query(value = "UPDATE employees SET email='admin@email.com' WHERE id=:id",nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") Integer id);


    //Named query
    List<Employee>retrieveEmployeeSalaryGreaterThan(Integer Salary);



}
