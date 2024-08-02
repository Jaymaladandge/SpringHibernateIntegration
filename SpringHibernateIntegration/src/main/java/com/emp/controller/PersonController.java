package com.emp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entities.Person;
import com.emp.service.impl.PersonServiceImpl;

@RestController
@RequestMapping("/person")
public class PersonController {

	
	@Autowired
	private PersonServiceImpl serviceImpl;
	
	
	
	@PutMapping("/puts/{id}")
	public ResponseEntity<Person> putUpdate(@PathVariable Long id, @RequestBody Person person){
		
		Person updatedPerson = serviceImpl.updateWithPut(id, person);
		return ResponseEntity.ok(updatedPerson);
	}
	
	
	@PatchMapping("/patches/{id}")
	public ResponseEntity<Person> patchUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updatedValue){
		
		Person updatdPerson = serviceImpl.updateWithPatch(id, updatedValue);
		return ResponseEntity.ok(updatdPerson);
	}
	
	
	
}
