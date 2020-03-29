package com.springboot.training.service;

import java.util.List;

import com.springboot.training.Student;

public interface StudentService {
	
	List<Student> getAllStudentds();
	
	  Student getStudentById(int id); 
	  Student saveStudent(Student student);
	  Student updateStudent(Student student, int id); 
	  String deleteStudent(int id);

}
