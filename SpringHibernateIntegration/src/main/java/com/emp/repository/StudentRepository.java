package com.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>
{

}
