package edu.wccnet.emeyer.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo2 {

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
			Customer  customerOne = new Customer("Joe","Doe","123 Pizza St","Brighton","MI","48114");
			Pizza pizzaOne = new Pizza("L","Pepperoni");
			Pizza pizzaTwo = new Pizza("M","Black Olives, Bacon");
			Customer  customerTwo = new Customer("Casmo","Kramer","123 Kramer st","New York","NY","12345");
			Pizza pizzaTree = new Pizza("S","Mushroom");
			
			PizzaOrder pizzaOrder = new PizzaOrder();
			pizzaOrder.addPizza(pizzaOne);
			pizzaOrder.addPizza(pizzaTwo);
			customerOne.addOrder(pizzaOrder);
			session.persist(customerOne);
			
			PizzaOrder pizzaOrder2 = new PizzaOrder();
			pizzaOrder2.addPizza(pizzaTree);
			customerTwo.addOrder(pizzaOrder2);
			session.persist(customerTwo);
			
			session.getTransaction().commit();
			
		}finally {
			
			session.close();
			factory.close();
			
		}

	}

}
