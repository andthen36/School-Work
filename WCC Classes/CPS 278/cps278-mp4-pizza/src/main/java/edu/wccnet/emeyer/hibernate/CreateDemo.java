package edu.wccnet.emeyer.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Customer.class)
								.addAnnotatedClass(Pizza.class)
								.addAnnotatedClass(PizzaOrder.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			Customer  customerOne = session.get(Customer.class, 6);
			Pizza pizza1 = new Pizza ("M","Mushroom, Spinach");
			PizzaOrder pizzaOrder = new PizzaOrder();
			pizzaOrder.addPizza(pizza1);
			customerOne.addOrder(pizzaOrder);
			session.persist(pizzaOrder);
			session.getTransaction().commit();
			
		}finally {
			
			session.close();
			factory.close();
			
		}

	}

}
