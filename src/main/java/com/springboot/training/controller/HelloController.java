package com.springboot.training.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.training.Student;
import com.springboot.training.dao.Studentdao;
import com.springboot.training.service.StudentService;

@RestController
public class HelloController {

	@Autowired
	private StudentService studentSvc;

	@RequestMapping("/sayHello")
	public String welcomeMessage() {

		return "Hello World";
	}

	// @RequestMapping("/getStudent")
	@GetMapping("/getStudent")
	public Student getStudent() {
		return new Student(1, "kartheek", "karth@gmail.com", 29);
	}

	// @RequestMapping("/getAllStudents")
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudentds() {
		// List<Student> list = Arrays.asList(new Student(1, "Arun kumar",
		// "arun_kumar@gaml", 23),
		// new Student(2, "Varun kumar", "varun_kuamer", 24));

		return studentSvc.getAllStudentds();
	}

	// @RequestMapping("/getStudent/{id}")
	@GetMapping("/getStudent/{id}")
	public Student getStudentById(@PathVariable("id") int id) {
		/*
		 * if(id ==1) {
		 * 
		 * return new Student(1, "Arun kumar", "arun_kumar@gaml", 23); }else if (id ==
		 * 2) { return new Student(2, "Varun kumar", "varun_kuamer", 24); }else { throw
		 * new RuntimeException("no student record found"); }
		 */

		return studentSvc.getStudentById(id);

	}

	// @RequestMapping(path = "/saveStudent", method=RequestMethod.POST )
	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody Student student) {
		System.out.println("student detail which are added are " + student);

		return studentSvc.saveStudent(student);

	}

	// @RequestMapping(path = "/saveStudent", method=RequestMethod.PUT )
	@PutMapping("/updateStudent/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") int id) {
		System.out.println("student detail which are added are " + student);
		return studentSvc.updateStudent(student, id);

	}

	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		System.out.println("deleting the student with id: " + id);
		return studentSvc.deleteStudent(id);
	}

}
