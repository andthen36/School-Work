package edu.wccnet.emeyer.hibernate;

import java.util.List;
import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;

public class DeleteDemo {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Customer.class)
								.addAnnotatedClass(Pizza.class)
								.addAnnotatedClass(PizzaOrder.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			String orderHql = "FROM PizzaOrder o";
			
			Query<PizzaOrder> orderQuery = session.createQuery(orderHql, PizzaOrder.class);
			List<PizzaOrder> orderResults = orderQuery.list();
			for (PizzaOrder po : orderResults) {
				System.out.println(po);
			}
			System.out.println("Please pick a order ID: ");
			
			PizzaOrder order = session.get(PizzaOrder.class, scan.nextInt());
			session.remove(order);
			session.getTransaction().commit();
			
		}finally {
			
			session.close();
			factory.close();
			
		}

	}

}
