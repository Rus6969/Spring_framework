package com.cybertek;

import com.cybertek.entity.Employee;
import com.cybertek.enums.Gender;
import com.cybertek.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;


@SpringBootApplication
public class OrmmappingApplication {
@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrmmappingApplication.class, args);
	}
     @PostConstruct
	public void addEmployee(){
		 Employee employee1 = new Employee("Ruslan","Samatov","russam4515@gmail.com", Date.valueOf("2020/04/23"), Gender.MALE,110000L);

		 employeeRepository.save(employee1);
	}


}
