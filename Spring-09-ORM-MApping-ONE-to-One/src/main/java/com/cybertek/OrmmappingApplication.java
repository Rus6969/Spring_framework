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


	public static void main(String[] args) {
		SpringApplication.run(OrmmappingApplication.class, args);
	}



}
