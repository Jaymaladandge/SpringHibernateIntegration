package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entities.Course;
import com.emp.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	
	@Autowired
	private CourseService courseService;
	
	
	@PostMapping("/save")
	public ResponseEntity<Course> persistCourse(@RequestBody Course course){
		Course savedCourse = courseService.saveCourse(course);
		return ResponseEntity.ok(savedCourse);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Course>> findAll(){
		List<Course> courses = courseService.getAllCourses();
		return ResponseEntity.ok(courses);
	}
}
