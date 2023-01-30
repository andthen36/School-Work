package edu.wccnet.emeyer.springMVC.Service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.emeyer.springMVC.dao.CustomerDAO;
import edu.wccnet.emeyer.springMVC.dao.OrderDAO;
import edu.wccnet.emeyer.springMVC.entity.Customer;
import edu.wccnet.emeyer.springMVC.entity.Order;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	@Transactional
	public List<Order> getOrders(int customerId) {
		// TODO Auto-generated method stub
		return orderDAO.getOrders(customerId);
	}

	@Override
	@Transactional
	public void saveOrder(Order theOrder) {
		// TODO Auto-generated method stub
		orderDAO.saveOrder(theOrder);
		
	}

	@Override
	@Transactional
	public Order getOrder(int id) {
		// TODO Auto-generated method stub
		return orderDAO.getOrder(id);
	}

	@Override
	@Transactional
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		orderDAO.deleteOrder(id);
	}

	@Transactional
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orderDAO.getOrders();
	}
}


