package edu.wccnet.emeyer.hibernate;

import java.util.List;
import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;

public class FetchDemo {

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
			
			String customerHql = "FROM Customer c";
			
			Query<Customer> customerQuery = session.createQuery(customerHql, Customer.class);
			List<Customer> customerResults = customerQuery.list();
			for (Customer customer : customerResults) {
				System.out.println(customer);
			}
			System.out.println("Please pick a customer ID: ");
			Query<Customer> query = session
					.createQuery("FROM Customer c WHERE c.id = :customerId", Customer.class);
			query.setParameter("customerId", 6);
			Customer customer = query.getSingleResult();
			System.out.println(customer.getPizzaOrderList());
			
			session.getTransaction().commit();
			
		}finally {
			
			session.close();
			factory.close();
			
		}

	}

}
