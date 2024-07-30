package com.emp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long passId;
	
	private String passpotNumber;
	
	@OneToOne
	@JoinColumn(name = "cust_id")
	@JsonBackReference
	private Customer customer;
	
	
}


/* 
 
 The cust_id column is unique because it enforces the one-to-one relationship between Customer and Passport. 
 Each Passport can only be linked to one Customer, and each Customer can only be linked to one Passport, which is why the 
 column has a UNI constraint. This constraint prevents multiple Passport records from being associated with the same Customer,
 thus preserving the integrity of the one-to-one mapping.
 We can see in database having column cust_id as unique key.
 
 
MUL vs UNI:

MUL (multiple) allows multiple rows to have the same value in that column. This is typically used for columns with many-to-one
or one-to-many relationships where multiple rows can refer to the same value.

UNI (unique) ensures that the value in the column is unique across the entire table, which is required for one-to-one 
relationships where each value must be unique to maintain the integrity of the relationship.
 
 
 */
 