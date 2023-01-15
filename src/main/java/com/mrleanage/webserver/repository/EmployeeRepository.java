package com.mrleanage.webserver.repository;

import com.mrleanage.webserver.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //All Crud Operations with Database
}
