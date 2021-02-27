package com.cybertek.repository;

import com.cybertek.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {


    @Query("select d from Department d where d.division in ?1")
    List<Department> gerDepartmentbyDivisionin(List<String>divisions);


/*
Named Queries – Property File
• We can define named queries by using a properties file called jpa-named- queries.properties inside the META-INF folder of our classpath.
• In a Spring Boot project, by default, this folder is not available. You need to first create META-INF folder inside /src/main/resources/.
 */
    List<Department>retrieveDepartmentByDivision(String division);

}
