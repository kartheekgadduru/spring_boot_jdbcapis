package com.springboot.training.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.training.Student;

@Repository
public class StudentdaoImpl implements Studentdao {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	public List<Student> getAllStudentds() {
		return jdbcTemplate.query("select *from student", (rs, rowNum) -> new Student(rs.getInt("id"),
				rs.getString("name"), rs.getString("email"), rs.getInt("age")));

	}


	
	public Student getStudentById(int id) { 
		String sql = "select *from student where id=:id";
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		
		return jdbcTemplate.queryForObject(sql,map, (rs, rowNum) -> new Student(rs.getInt("id"),
				rs.getString("name"), rs.getString("email"), rs.getInt("age")));
	    
	    
	}



	@Override
	public Student saveStudent(Student student) {
		String sql = "insert into student (id, name, email, age) values (:id, :name, :email, :age)";
		Map<String, Object> map = new HashMap<>();
		map.put("id", student.getId());
		map.put("name", student.getName());
		map.put("email",student.getEmail());
		map.put("age", student.getAge());
		jdbcTemplate.update(sql, map);
		return student;
	}



	@Override
	public Student updateStudent(Student student, int studentId) {
		String updateSql = "update student set id=:id, name=:name, email=:email, age=:age where id=:studentId";
		Map<String, Object> map = new HashMap<>();
		map.put("id", student.getId());
		map.put("name", student.getName());
		map.put("email",student.getEmail());
		map.put("age", student.getAge());
		map.put("studentId", studentId);		
		jdbcTemplate.update(updateSql, map);
		return student;
	}



	@Override
	public String deleteStudent(int id) {
		String deleteSQL = "delete from student where id=:id";
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
			
		jdbcTemplate.update(deleteSQL, map);
		
		return "Student with ID: "+ id+ "has been deleted";
	}
	
	

	
	 

}
