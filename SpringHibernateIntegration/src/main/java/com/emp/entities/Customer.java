package com.emp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long custId;

	private String name;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
	@JsonManagedReference
	private Passport passport;

	public long getId() {
		return custId;
	}

	public void setId(long id) {
		this.custId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) { // Association properly maintain on parent side
		System.out.println("-------------------setPassport(Passport passport)----------------------");
		this.passport = passport;
		//if (passport != null)        For association, we can write this code here or in service while persisting the entity 
		//	passport.setCustomer(this);
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", passport=" + passport.getPassId() + ", "+passport.getPasspotNumber();
	}
	
}
