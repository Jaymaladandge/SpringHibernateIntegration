package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entities.Employee;
import com.emp.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmps(){
		List<Employee> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> fetchEmployee(@PathVariable int empId){
		Employee employee = employeeService.getEmployee(empId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	
	@PostMapping("/save")
	public Employee persistEmployee(@RequestBody Employee employee){
		Employee employee2 = employeeService.saveEmployee(employee);
		//return ResponseEntity.status(HttpStatus.CREATED).body(employee2);
		return employee2;
	}

	
	@PostMapping("/update")
	public ResponseEntity<Employee> modifyEmployee(@RequestBody Employee employee){
		return null;
	}
	
	
	@PostMapping("/update/{empId}")
	public ResponseEntity<Employee> modifyEmployee(@PathVariable int empId, @RequestBody Employee employee){
		Employee employee2 = employeeService.updateEmployee(empId, employee);
		return ResponseEntity.ok(employee2);
	}
	
	
	@GetMapping("/delete/{empId}")
	public ResponseEntity<String> removeEmployee(@PathVariable int empId){
		return employeeService.deleteEmployee(empId);
	}
	
	
	
	
}
