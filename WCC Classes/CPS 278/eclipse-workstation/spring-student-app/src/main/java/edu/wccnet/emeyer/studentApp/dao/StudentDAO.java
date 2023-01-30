package edu.wccnet.emeyer.studentApp.dao;

import java.util.List;

import edu.wccnet.emeyer.studentApp.entity.Student;

public interface StudentDAO {

	public List<Student> getStudent();

	public void saveStudent(Student theStudent);

	public Student getStudent(int id);

	public void deleteStudent(int id);
		
}
