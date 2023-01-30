package edu.wccnet.emeyer.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.wccnet.emeyer.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session

		Session session = factory.getCurrentSession();
		
		try {
		
			
			// start a transaction
			session.beginTransaction();
			
			// Query student
			
			List<Student> theStudents =  session.createQuery("from Student").getResultList();
			
			// Display students
			
			displayStudents(theStudents);
			
			
			
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			// Display students
			System.out.println("\nStudents with last name = Doe");
			displayStudents(theStudents);
			
			
			
			//query students first name daffy or las name doe
			
			theStudents = 
					session.createQuery
					("from Student s where s.lastName='Doe' "
							+ "OR s.firstName='Daffy'").getResultList();
			
			System.out.println("\nStudents with last name = Doe OR first name = Daffy");
			displayStudents(theStudents);
			
			// query students where email Like '%luv2code.com'
			theStudents = 
					session.createQuery
					("from Student s where s.email"
							+ "LIKE '%luv2code.com'").getResultList();
			
			System.out.println("\nStudents with email = luv2code.com");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			
			
		}
		
		
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
