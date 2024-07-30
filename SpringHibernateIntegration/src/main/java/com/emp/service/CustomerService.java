package com.emp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.emp.entities.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);
	
	List<Customer> getAllCustomers();
	
	Customer getCustomer(long id);
	
	ResponseEntity<String> deleteCustomer(long id);
	
	Customer updateCustomer(long id, Customer customer);

}
