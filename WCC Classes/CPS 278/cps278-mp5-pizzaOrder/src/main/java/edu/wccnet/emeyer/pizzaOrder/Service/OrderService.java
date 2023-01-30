package edu.wccnet.emeyer.pizzaOrder.Service;

import java.util.List;

import edu.wccnet.emeyer.pizzaOrder.entity.Customer;
import edu.wccnet.emeyer.pizzaOrder.entity.Order;

public interface OrderService {

	public List<Order> getOrders(int customerId);

	public void saveOrder(Order theOrder);

	public Order getOrder(int id);

	public void deleteOrder(int id);

}
