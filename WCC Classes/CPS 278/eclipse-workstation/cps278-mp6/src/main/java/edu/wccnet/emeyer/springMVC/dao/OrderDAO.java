package edu.wccnet.emeyer.springMVC.dao;

import java.util.List;


import edu.wccnet.emeyer.springMVC.entity.Customer;
import edu.wccnet.emeyer.springMVC.entity.Order;

public interface OrderDAO {

	public List<Order> getOrders(int customerId);
	
	public List<Order> getOrders();

	public void saveOrder(Order theOrder);

	public Order getOrder(int id);

	public void deleteOrder(int id);
		
}
