package edu.wccnet.emeyer.restDemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.wccnet.emeyer.restDemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;
	
	@PostConstruct
	public void loadStudents() {
		students = new ArrayList<>();
		students.add(new Student(1,"Evan","Meyer","emeyer@wcnet.edu"));
		students.add(new Student(2,"Cosmo","Kramer","ckramer@wcnet.edu"));
	}
	@GetMapping("/students")
	public List<Student> getStudents(){
		return students;
	}
	
	@GetMapping("students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		for (Student student : students) {
			if (student.getId() == studentId)
				return student;
		}
		throw new StudentNotFoundException("student id not found. id: " + studentId);
	}
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatue(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
public ResponseEntity<StudentErrorResponse> handleException(Exception e){
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatue(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
