package edu.wccnet.emeyer.pizzaOrder.dao;

import java.util.List;

import edu.wccnet.emeyer.pizzaOrder.entity.Customer;
import edu.wccnet.emeyer.pizzaOrder.entity.Order;

public interface OrderDAO {

	public List<Order> getOrders(int customerId);

	public void saveOrder(Order theOrder);

	public Order getOrder(int id);

	public void deleteOrder(int id);
		
}
