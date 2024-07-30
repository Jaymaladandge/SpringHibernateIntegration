package com.emp.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int empId;

	private String name;

	private String email;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", orphanRemoval = true)
	@JsonManagedReference
	private List<Address> addresses;

}
//@JsonManagedReference : To avoid the infinite recursion you are seeing in the JSON response. we can use postman to see.