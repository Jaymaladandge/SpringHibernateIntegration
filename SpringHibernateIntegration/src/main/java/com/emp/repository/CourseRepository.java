package com.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
