package edu.wccnet.emeyer.studentApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.emeyer.studentApp.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Student> getStudent() {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Student> query = session.createQuery("from Student s order by lastName", 
				Student.class);
	
		return query.getResultList();
	}
	@Override
	public void saveStudent(Student theStudent) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		//session.save(theStudent);
		session.saveOrUpdate(theStudent);
	}
	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Student.class, id);
	}
	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Student where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
