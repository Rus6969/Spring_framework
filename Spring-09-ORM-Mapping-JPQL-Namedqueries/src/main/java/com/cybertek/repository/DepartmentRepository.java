package com.cybertek.repository;

import com.cybertek.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.w3c.dom.ls.LSInput;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {


    @Query("select d from Department d where d.division in ?1")
    List<Department> getDepartmentbyDivisionin(List<String>divisions);


/*
Named Queries – Property File
• We can define named queries by using a properties file called jpa-named- queries.properties inside the META-INF folder of our classpath.
• In a Spring Boot project, by default, this folder is not available. You need to first create META-INF folder inside /src/main/resources/.
 */
    List<Department>retrieveDepartmentByDivision1(String division);



//Native queries we need add annotations regular query
 // in properties file we are doing concatenation since we are using parameters
    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContains(String pattern);

    List<Department>findRussellDepartmet(String division);


// Named Native
  List<Department>countAllDepartments();
  // since we are returning only number of departmets not department object we do not neet list also look in Department Entity
  Integer countDepartments();

}
