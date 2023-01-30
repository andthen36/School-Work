package edu.wccnet.emeyer.springMVC.controller;

import java.util.ArrayList;



import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.wccnet.emeyer.springMVC.Service.CustomerService;
import edu.wccnet.emeyer.springMVC.Service.OrderService;
import edu.wccnet.emeyer.springMVC.entity.Customer;
import edu.wccnet.emeyer.springMVC.entity.Order;




@RestController
@RequestMapping("/api")
public class MyRestController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;
	
	private List<Customer> customers;
	
	private List<Order> orders;
	
	@PostConstruct
	public void loadCustomers() {
		customers = new ArrayList<>();
	}
	
	// Getting all customers from JSON
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	//Getting a specific customer
	@GetMapping("customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		return customerService.getCustomer(customerId);
	}
	
	// Delete to remove a customer
	@DeleteMapping("/customers/{customerId}")
	public String removeCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
		return "Customer Number: " + customerId + " has been deleted";
	}
	
	// Post to add a customer
	@PostMapping("/customers")
	public void addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		customerService.saveCustomer(customer);
	}
	
// put to update a customer
	@PutMapping("/customers")
	public void updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
	}
		
	
	// Load Orders
	@PostConstruct
	public void loadOrders() {
		orders = new ArrayList<>();
	}
	
	// Gets order list
	@GetMapping("/orders")
	public List<Order> getOrders(){
		return orderService.getOrders();
	}
	
	// Gets specific order
	@GetMapping("orders/{orderId}")
	public Order getOrder(@PathVariable int orderId) {
		return orderService.getOrder(orderId);
	}
	
	//Post a new order
	@PostMapping("/orders")
	public void addOrder(@RequestBody Order order) {
		order.setId(0);
		orderService.saveOrder(order);
	}
	
	@PutMapping("/orders")
	public void updateOrder(@RequestBody Order order) {
		orderService.saveOrder(order);
	}
	
	@DeleteMapping("/orders/{orderId}")
	public void removeOrder(@PathVariable int orderId) {
		orderService.deleteOrder(orderId);
	}
	
	@ExceptionHandler
	public ResponseEntity<APIErrorResponse> handleException(NotFoundException e){
		APIErrorResponse error = new APIErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatue(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<APIErrorResponse> handleException(Exception e){
		APIErrorResponse error = new APIErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatue(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
