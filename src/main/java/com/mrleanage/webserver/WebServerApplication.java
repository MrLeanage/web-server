package com.mrleanage.webserver;

import com.mrleanage.webserver.model.Employee;
import com.mrleanage.webserver.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WebServerApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
//		Employee employee = new Employee();
//		employee.setFirstName("Uthpala");
//		employee.setLastName("Liyanage");
//		employee.setEmailID("uthpala@gmail.com");
//		employeeRepository.save(employee);
//
//
//		Employee employee1 = new Employee();
//		employee1.setFirstName("Dilshan");
//		employee1.setLastName("Liyanage");
//		employee1.setEmailID("dilshan@gmail.com");
//		employeeRepository.save(employee1);
	}
}
