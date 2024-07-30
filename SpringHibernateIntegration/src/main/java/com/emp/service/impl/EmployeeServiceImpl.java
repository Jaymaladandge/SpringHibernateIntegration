package com.emp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emp.entities.Address;
import com.emp.entities.Employee;
import com.emp.exceptions.ResourceNotFoundException;
import com.emp.repository.EmployeeRepository;
import com.emp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee saveEmployee(Employee employee) {

		if (employee.getAddresses() != null) {
			for (Address address : employee.getAddresses()) {
				address.setEmployee(employee);
			}
		}

		return repository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public Employee updateEmployee(int empId, Employee employee) {

		Optional<Employee> optional = repository.findById(empId);
		Employee savedEmp = optional
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found with given id : " + empId));

		savedEmp.setEmail(employee.getEmail());
		savedEmp.setName(employee.getName());

		List<Address> updatedAddresses = employee.getAddresses();

		// Disassociate existing addresses
		for (Address address : savedEmp.getAddresses()) {
			address.setEmployee(null);
		}
		
		// Update the saved employee's address list
		savedEmp.getAddresses().clear();
		for (Address address : updatedAddresses) {
			address.setEmployee(savedEmp);
			savedEmp.getAddresses().add(address);
		}

		return repository.save(savedEmp);
	}

	@Override
	public ResponseEntity<String> deleteEmployee(int empId) {
		repository.deleteById(empId);
		return ResponseEntity.ok("record deleted with given id : " + empId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public Employee getEmployee(int empId) {
		Optional<Employee> optional = repository.findById(empId);
		Employee employee = optional
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found with given id : " + empId));
		return employee;
	}

}
