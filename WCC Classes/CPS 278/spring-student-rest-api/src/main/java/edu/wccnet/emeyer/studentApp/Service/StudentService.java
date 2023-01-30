package edu.wccnet.emeyer.studentApp.Service;

import java.util.List;

import edu.wccnet.emeyer.studentApp.entity.Student;

public interface StudentService {

	public List<Student> getStudents();

	public void saveStudent(Student theStudent);

	public Student getStudent(int id);

	public void deleteStudent(int id);
}
