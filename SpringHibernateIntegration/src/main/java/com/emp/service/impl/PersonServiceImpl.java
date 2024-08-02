package com.emp.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entities.Person;
import com.emp.repository.PersonRepository;

@Service
public class PersonServiceImpl {

	
	@Autowired
	private PersonRepository repository;
	
	
	public Person updateWithPut(Long id, Person person) {
		
		Person savedPerson = repository.findById(id).orElseThrow();
		savedPerson.setAddress(person.getAddress());
		return repository.save(savedPerson);
	}
	
	
	public Person updateWithPatch(Long id, Map<String, Object> updatedValue) {
		
		Person savedPerson = repository.findById(id).orElseThrow();
		savedPerson.setAddress((String)updatedValue.get("address"));
		return repository.save(savedPerson);
	}
	
	
}
