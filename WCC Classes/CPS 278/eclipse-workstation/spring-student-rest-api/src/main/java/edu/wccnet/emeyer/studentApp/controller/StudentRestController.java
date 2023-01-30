package edu.wccnet.emeyer.studentApp.controller;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.wccnet.emeyer.studentApp.entity.Student;
import edu.wccnet.emeyer.studentApp.Service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	@Autowired
	private StudentService studentService;
	
	private List<Student> students;
	
	@PostConstruct
	public void loadStudents() {
		students = new ArrayList<>();
		students.add(new Student(1,"Evan","Meyer","emeyer@wcnet.edu"));
		students.add(new Student(2,"Cosmo","Kramer","ckramer@wcnet.edu"));
	}
	@GetMapping("/students")
	public List<Student> getStudents(){
		return studentService.getStudents();
	}
	
	@GetMapping("students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		return studentService.getStudent(studentId);
	}
	@PostMapping("/students")
	public void addStudent(@RequestBody Student student) {
		student.setId(0);
		studentService.saveStudent(student);
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
