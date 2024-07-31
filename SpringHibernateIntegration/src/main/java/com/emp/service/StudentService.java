package com.emp.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.emp.entities.Student;

public interface StudentService {

	Student addStudentToCourse(long studId, long courseId);
	
	
	List<Student> getAllStudents();
	
	
	Student getStudent(long id);
	
	
	String deleteStudent(long id);
	
	
	Student updateStudent(long id, Student student);
	
	
	Student saveStudent(Student student);
	
}
