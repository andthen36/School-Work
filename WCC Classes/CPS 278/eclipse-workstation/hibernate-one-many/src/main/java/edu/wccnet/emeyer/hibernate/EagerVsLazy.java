package edu.wccnet.emeyer.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EagerVsLazy {

	public static void main(String[] args) {
	SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(College.class)
							.addAnnotatedClass(Campus.class)
							.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	
	try {
		session.beginTransaction();
		Query<College> query = 
				session.createQuery("from College c join c.campuses where c.id = :collegeId", College.class);
		
		query.setParameter("collegeId", 6);
		College college = query.getSingleResult();
		
		System.out.println(college);
		System.out.println(college.getCampuses());
		session.getTransaction().commit();
	}finally {
		session.close();
		factory.close();
	}
	

}
}
