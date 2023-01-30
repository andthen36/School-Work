package edu.wccnet.emeyer.pizzaOrder.dao;

import java.util.List;

import edu.wccnet.emeyer.pizzaOrder.entity.Customer;

public interface CustomerDAO {

	public void saveCustomer(Customer theStudent);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	List<Customer> getCustomers(String sort);
		
}
