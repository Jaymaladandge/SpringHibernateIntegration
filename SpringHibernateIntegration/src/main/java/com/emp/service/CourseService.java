package com.emp.service;

import java.util.List;

import com.emp.entities.Course;

public interface CourseService {

	
	Course saveCourse(Course course);
	
	List<Course> getAllCourses();
	
}
