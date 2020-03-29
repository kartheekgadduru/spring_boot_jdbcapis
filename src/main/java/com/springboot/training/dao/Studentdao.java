package com.springboot.training.dao;

import java.util.List;

import com.springboot.training.Student;

public interface Studentdao {
	
	
	List<Student> getAllStudentds();
	
	  Student getStudentById(int id); 
	  Student saveStudent(Student student);
	  Student updateStudent(Student student, int id); 
	  String deleteStudent(int id);
	 

}
