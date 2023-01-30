package edu.wccnet.emeyer.springMVC.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.emeyer.springMVC.entity.Customer;
import edu.wccnet.emeyer.springMVC.entity.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Order> getOrders(int customerId) {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer c where id = :customerId", 
				Customer.class);
		query.setParameter("customerId", customerId);
		Customer customer = query.getSingleResult();
		System.out.println(customer.getOrderList());
		return customer.getOrderList();
	}
	
	public List<Order> getOrders() {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Order> query = session.createQuery("from Order", 
				Order.class);
		return query.getResultList();
	}

	@Override
	public void saveOrder(Order theOrder) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		//session.save(theStudent);
		session.saveOrUpdate(theOrder);
	}
	@Override
	public Order getOrder(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.get(Order.class, id);
		return null;
	}
	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Order order = session.get(Order.class, id);
		session.remove(order);
	}

}
