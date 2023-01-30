package edu.wccnet.emeyer.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.wccnet.emeyer.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session

		Session session = factory.getCurrentSession();
		
		try {
			
			
			int studentId = 1;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the PK
			
			System.out.println("\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			//delete the student
			System.out.println("Deleting student" + myStudent);
			session.delete(myStudent);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
	}

}
