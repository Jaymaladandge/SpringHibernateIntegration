package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entities.Student;
import com.emp.service.StudentService;

@RestController
@RequestMapping("/stud")
public class StudentController {

	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping
	public ResponseEntity<List<Student>> getAll(){
		List<Student> students = studentService.getAllStudents();
		return ResponseEntity.ok(students);
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<Student> persist(@RequestBody Student student){
		Student savedStudent = studentService.saveStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
	}
	
	
	@PostMapping("/{studId}/course/{courseId}")
	public ResponseEntity<Student> enrollStudentInCourse(@PathVariable Long studId, @PathVariable Long courseId){
		Student student = studentService.addStudentToCourse(studId, courseId);
		return ResponseEntity.ok(student);
	}
	
	
	@PostMapping("/update/{id}")
	public ResponseEntity<Student> modifyStudent(@PathVariable long id, @RequestBody Student student){
		Student updatedStudent = studentService.updateStudent(id, student);
		return new ResponseEntity<Student>(updatedStudent, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeStudent(@PathVariable long id){
		String msg = studentService.deleteStudent(id);
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> fetchStudent(long id){
		Student student = studentService.getStudent(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	
	
}
