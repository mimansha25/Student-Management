package com.excelr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	
}
