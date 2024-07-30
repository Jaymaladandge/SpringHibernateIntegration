package com.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entities.Passport;

public interface PassportRepository extends JpaRepository<Passport, Long> {

}
