package com.excelr.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Student;
import com.excelr.exception.IdNotFoundException;
import com.excelr.service.StudentService;

@RestController


@RequestMapping("/api/v1")

public class StudentController {

	@Autowired

	StudentService studentService;
	
	@PostMapping("/student")
	
	public ResponseEntity<Student> addStudent(@RequestBody Student student)
	{
		return new ResponseEntity<Student>(studentService.addStudent(student), HttpStatus.OK);
		
	}
	
	@GetMapping("/student")

	public ResponseEntity<List<Student>> getAllStudent()
	{
		return new ResponseEntity<List<Student>>(studentService.getAllStudent(), HttpStatus.OK);
	}
	
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id)
	{
		return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/student/{id}")

	public ResponseEntity<String> deleteStudent(@PathVariable int id)
	{
		return new ResponseEntity<String>(studentService.deleteStudent(id), HttpStatus.OK);
	}
	 
	@PutMapping("/student/{id}")
	
	public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody Student student)
	{
		return new ResponseEntity<String>(studentService.updateStudent(id, student), HttpStatus.OK);
	}
	
	
	
	
}
