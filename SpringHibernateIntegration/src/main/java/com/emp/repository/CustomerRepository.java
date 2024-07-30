package com.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
