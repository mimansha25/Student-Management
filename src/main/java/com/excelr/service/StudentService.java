package com.excelr.service;

import java.util.List;

import com.excelr.entity.Student;

public interface StudentService {
	
	Student addStudent(Student student);
	List<Student> getAllStudent();
	Student getStudentById(int id);
	String deleteStudent(int id);
	String updateStudent(int id, Student student);


}
