package edu.wccnet.emeyer.pizzaOrder.Service;

import java.util.List;

import edu.wccnet.emeyer.pizzaOrder.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers(String sort);

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
