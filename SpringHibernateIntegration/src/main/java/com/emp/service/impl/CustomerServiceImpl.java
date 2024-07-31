package com.emp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emp.entities.Customer;
import com.emp.entities.Passport;
import com.emp.exceptions.ResourceNotFoundException;
import com.emp.repository.CustomerRepository;
import com.emp.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Override
	public Customer saveCustomer(Customer customer) {
		System.out.println("================customer=================" + customer);
		return repository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}

	@Override
	public Customer getCustomer(long id) {
		Optional<Customer> optional = repository.findById(id);
		Customer customer = optional
				.orElseThrow(() -> new ResourceNotFoundException("Resouce not found on server...!" + id));
		return customer;
	}

	@Override
	public ResponseEntity<String> deleteCustomer(long id) {
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Resource dleted with given ID " + id);
	}

	@Transactional
	public Customer updateCustomer(long id, Customer customer) {

		Customer savedCustomer = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resouce not found on server...!" + id));
		Passport savedPassport = savedCustomer.getPassport();


		// null check for customer
		if (customer != null) {

			savedPassport.setCustomer(null);
			savedCustomer.setPassport(null);

			String custName = customer.getName() != null ? customer.getName() : savedCustomer.getName();
			Passport newPassport = customer.getPassport();

			// Update the customer's name
			savedCustomer.setName(custName);

			// null check for passport
			if (savedPassport != null && newPassport != null) {

				// Update the passport
				savedPassport.setCustomer(savedCustomer);
				savedPassport.setPasspotNumber(newPassport.getPasspotNumber());

				// Update the customer's passport
				savedCustomer.setPassport(savedPassport);
				System.out.println("=============savedCustomer in if=============" + savedCustomer);
				
			} else {
				// Update the customer's passport
				newPassport = (newPassport == null) ? savedPassport : newPassport;
				newPassport.setCustomer(savedCustomer);
				savedCustomer.setPassport(newPassport);
				System.out.println("=============savedCustomer in else=============" + savedCustomer);
			}
			
			System.out.println("======updateCustomer(long id, Customer customer) savedCustomer===" + savedCustomer);
			repository.save(savedCustomer);
		}

		return savedCustomer;
	}

}
