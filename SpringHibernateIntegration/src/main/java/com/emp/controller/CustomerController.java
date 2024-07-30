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

import com.emp.entities.Customer;
import com.emp.service.CustomerService;

@RestController
@RequestMapping("/cust")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAll(){
		List<Customer> list = customerService.getAllCustomers();
		return ResponseEntity.ok(list);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> fetchCustomer(@PathVariable long id){
		Customer customer = customerService.getCustomer(id);
		return ResponseEntity.ok(customer);		
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<Customer> persistCustomer(@RequestBody Customer customer){
		Customer savedCust = customerService.saveCustomer(customer);
		return new ResponseEntity<Customer>(savedCust,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> removeCust(@PathVariable long id){
		return customerService.deleteCustomer(id);
	}
	
	
	@PostMapping("/update/{id}")
	public ResponseEntity<Customer> modifyCust(@PathVariable long id, @RequestBody Customer customer){
		Customer updatedCust = customerService.updateCustomer(id, customer);
		return ResponseEntity.status(HttpStatus.OK).body(updatedCust);
	}
}
