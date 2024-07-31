package com.emp.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stud_id")
	private long studeId;

	private String name;

	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "stud_course_info", joinColumns = {@JoinColumn(name="stud_id")}, inverseJoinColumns = {@JoinColumn(name="course_id")})
	//@JsonIgnore
	@JsonManagedReference
	private Set<Course> courses;

	@Override
	public String toString() {
		for(Course course : courses) {
			System.out.println(course.getCourseId()+", "+course.getName());
		}
		return "Student [studeId=" + studeId + ", name=" + name ;
	}

}


/* 
 
We used private Set<Course> courses; in Student class. private Set<Student> students; in Course class this will use Primary key 
in JoinTable column. List datatype will use MUL key. 
 
stud_id	bigint	NO	PRI		
course_id	bigint	NO	PRI		  
  
A composite primary key is a primary key that consists of two or more columns in a database table. These columns together 
uniquely identify a record in the table. In other words, the combination of values in these columns must be unique across 
the table.	

Composite primary keys are typically used in scenarios where a single column is not sufficient to uniquely identify a row.
use in Join Tables in Many-to-Many Relationships.  
  
  
 */
