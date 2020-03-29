package com.springboot.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.training.Student;
import com.springboot.training.dao.Studentdao;


@Service
public class StudentSvcImpl implements StudentService{
	
	@Autowired
	private Studentdao studentdao;

	@Override
	public List<Student> getAllStudentds() {
		
		return studentdao.getAllStudentds();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentdao.getStudentById(id);
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentdao.saveStudent(student);
	}

	@Override
	public Student updateStudent(Student student, int id) {
		// TODO Auto-generated method stub
		return studentdao.updateStudent(student, id);
	}

	@Override
	public String deleteStudent(int id) {
		
		return studentdao.deleteStudent(id);
	}

}
