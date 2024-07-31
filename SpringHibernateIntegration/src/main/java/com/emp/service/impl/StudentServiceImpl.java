package com.emp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entities.Course;
import com.emp.entities.Student;
import com.emp.exceptions.ResourceNotFoundException;
import com.emp.repository.CourseRepository;
import com.emp.repository.StudentRepository;
import com.emp.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudent(long id) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found resource with given Id "+id));
		return student;
	}

	@Override
	public String deleteStudent(long id) {
		studentRepository.deleteById(id);
		return "Deleted successfully";
	}

	@Override
	public Student updateStudent(long id, Student student) {
		
		return null;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student addStudentToCourse(long studId, long courseId) {
		
		Student student = studentRepository.findById(studId).orElseThrow(() -> new ResourceNotFoundException("Resource not found with given Id "+studId));
		Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Resource not found with given Id "+courseId));
		
		student.getCourses().add(course);	//association
		course.getStudents().add(student);	//association
		
		return studentRepository.save(student);
	}

}
