package edu.wccnet.emeyer.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerVsLazy2 {

	public static void main(String[] args) {
	SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(College.class)
							.addAnnotatedClass(Campus.class)
							.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	
	try {
		session.beginTransaction();
		College college = session.get(College.class, 6);
		//session.save(college);
		//session.persist(college);
		System.out.println(college);
		System.out.println(college.getCampuses());
		session.getTransaction().commit();
	}finally {
		session.close();
		factory.close();
	}
	

}
}
