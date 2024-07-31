package com.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entities.Course;
import com.emp.repository.CourseRepository;
import com.emp.service.CourseService;



@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository repository;
	
	
	@Override
	public Course saveCourse(Course course) {
		return repository.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		return repository.findAll();
	}

	
	
	
	

}
