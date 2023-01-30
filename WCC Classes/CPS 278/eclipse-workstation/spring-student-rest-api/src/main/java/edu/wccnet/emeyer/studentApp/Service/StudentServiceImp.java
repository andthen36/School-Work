package edu.wccnet.emeyer.studentApp.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.emeyer.studentApp.controller.StudentNotFoundException;
import edu.wccnet.emeyer.studentApp.dao.StudentDAO;
import edu.wccnet.emeyer.studentApp.entity.Student;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	@Transactional
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentDAO.getStudent();
	}

	@Override
	@Transactional
	public void saveStudent(Student theStudent) {
		// TODO Auto-generated method stub
		studentDAO.saveStudent(theStudent);
		
	}

	@Override
	@Transactional
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return studentDAO.getStudent(id);
	}
	@Transactional
	public Student getStudents(int id) {
		Student student = studentDAO.getStudent(id);
		if(student == null) {
			throw new StudentNotFoundException("student id not found. id: " + id);
		}
		return studentDAO.getStudent(id);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentDAO.deleteStudent(id);
	}

}
