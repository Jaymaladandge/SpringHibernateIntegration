package com.emp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.emp.entities.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	
	Employee updateEmployee(Employee employee);
	
	
	Employee updateEmployee(int empId, Employee employee);
	
	
	ResponseEntity<String> deleteEmployee(int empId);
	
	
	List<Employee> getAllEmployees();
	
	
	Employee getEmployee(int empId);
	
}
