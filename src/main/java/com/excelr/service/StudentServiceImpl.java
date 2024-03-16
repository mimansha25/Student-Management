package com.excelr.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.entity.Student;
import com.excelr.exception.IdNotFoundException;

import com.excelr.repository.StudentRepository;
import com.excelr.utility.AppConstant;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	
	@Override
	public Student addStudent(Student student) {
		
		
		
	    Student student1=studentRepository.save(student);
		return student1;
	}

	
	@Override
	public List<Student> getAllStudent() {
		 
		return studentRepository.findAll();
	}
	
	

	@Override
	public Student getStudentById(int id) {
	   Optional<Student> optionalStudent =  studentRepository.findById(id);
	  Student student=null;
	  
	  if(optionalStudent.isPresent())
	   {
		  student= optionalStudent.get();
	   }
	  else
	  {
		  throw new IdNotFoundException(AppConstant.ID_NOT_FOUND_MESSAGE);
	  }
		
		return student;
	}

	
	
	@Override
	public String deleteStudent(int id) {
		String msg="";
		   if(studentRepository.existsById(id))
		   {
			   studentRepository.deleteById(id);
			   msg="student deleted";
		   }
		   else
		   {
			   throw new IdNotFoundException(AppConstant.ID_NOT_FOUND_MESSAGE);
		   }
		
		return msg;
	}

	
	
	@Override
	public String updateStudent(int id, Student student) {
		String msg="";
		   if(studentRepository.existsById(id))
		   {
			    Student student2 = studentRepository.findById(id).get();
			    student2.setFirstName(student.getFirstName());
			    student2.setLastName(student.getLastName());
			    student2.setMobileNo(student.getMobileNo());
			    student2.setCourse(student.getCourse());
			    
			    studentRepository.save(student2);
			    msg="student successfully updated";
			    
		   }
		   else
		   {
			   throw new IdNotFoundException(AppConstant.ID_NOT_FOUND_MESSAGE);
		   }
		return msg;
	}

	

}
