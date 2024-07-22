package com.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
