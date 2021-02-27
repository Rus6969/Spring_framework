package com.cybertek;
import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class JpqlApplication {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpqlApplication.class, args);
	}

	@PostConstruct
	public void testEmployee(){

		System.out.println(employeeRepository.getEmployeeDetail());
		System.out.println(employeeRepository.getEmployeeSalary());
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println();
		employeeRepository.updateEmployeeJPQL(1);
		System.out.println("-0-0-0-0-0-0-0-0-0-0-0-");
		System.out.println(employeeRepository.retrieveEmployeeSalaryGreaterThan(20000));
		System.out.println("10100101010101010101010100101010100110010101010101010101");
		System.out.println(departmentRepository.findRussellDepartmet("Kids"));
		System.out.println("NUMBER OF ALL DEPARTMENTS ");
		System.out.println(departmentRepository.countAllDepartments());

	}




}
