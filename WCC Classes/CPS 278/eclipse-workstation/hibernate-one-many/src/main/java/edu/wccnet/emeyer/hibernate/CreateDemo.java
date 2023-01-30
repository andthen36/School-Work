package edu.wccnet.emeyer.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(College.class)
								.addAnnotatedClass(Campus.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			College college = new College("WCC");
			Campus mainCampus = new Campus
					("4800 East Huron River Dr.", "Ann Arbor", "MI", "48105");
			Campus ypsiCampus = new Campus
					("322 Harriet St", "Ypsilanti", "MI", "48197");
			college.add(ypsiCampus);
			college.add(mainCampus);
			session.save(college);
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}

	}

}
