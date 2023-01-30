package edu.wccnet.emeyer.pizzaOrder.controller;

import java.util.ArrayList;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.wccnet.emeyer.pizzaOrder.Service.CustomerService;
import edu.wccnet.emeyer.pizzaOrder.Service.OrderService;
import edu.wccnet.emeyer.pizzaOrder.dao.CustomerDAO;
import edu.wccnet.emeyer.pizzaOrder.entity.Customer;
import edu.wccnet.emeyer.pizzaOrder.entity.Order;
import edu.wccnet.emeyer.pizzaOrder.entity.Pizza;
import edu.wccnet.emeyer.pizzaOrder.entity.PizzaService;

@Controller
@RequestMapping("/pizza")
public class MainController {
	
	private Order order;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		model.addAttribute("customers",customerService.getCustomers(null));
		return "list-customer";
	}
	@PostMapping("/addCustomer")
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add-customer";
	}
	@PostMapping("/processCustomer")
	public String processCustomer(@ModelAttribute("customer")Customer theCustomer) {
		System.out.println(theCustomer);
		customerService.saveCustomer(theCustomer);
		return "redirect:/pizza/list";
		
	}
	@PostMapping("/updateCustomer")
	public String updateCustomer(Model model, @RequestParam("customerId") int id) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer",customer);
		return "add-customer";
		
	}
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/pizza/list";
		
	}
	
	
	@RequestMapping("/addOrder")
	public String addOrder(Model model, @ModelAttribute("newPizza")Pizza pizza) {
		
		System.out.println(pizza.getSize());
		order.addPizza(pizza);
		System.out.println(order.getCustomer());
		for (Pizza eachPizza : order.getPizzaList()) {
			System.out.println(eachPizza);
		}
		model.addAttribute("order", order);
		return "confirmation";
		
	}
	@RequestMapping("/orderPizza")
	public ModelAndView orderPizza(Model model, @RequestParam("customerId") int id) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customerName", customer.getFirstName() + " " + customer.getLastName());
		if (order == null) {
			order = new Order();
			order.setCustomer(customer);
		}
		return new ModelAndView("order-pizza", "newPizza", new Pizza());
	}
	
	@RequestMapping("/orderHistory")
	public String listOrders(Model model, @RequestParam("customerId") int id) {
		model.addAttribute("orders", orderService.getOrders(id));
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customerName", customer.getFirstName() + " " + customer.getLastName());
		model.addAttribute("customerId", customer.getId());
		return "list-order";
		
	}
	@RequestMapping("/deletePizza")
	public String deletePizza( @RequestParam("pizzaId") int id, Model model) {
		order.getPizzaList().remove(id-1);
		model.addAttribute("order", order);
		return "confirmation";
	}
	@RequestMapping("/placeOrder")
	public String plaseOrder( @RequestParam("customerId") int id, RedirectAttributes redirectAttributes) {
		orderService.saveOrder(order);
		order = null;
		redirectAttributes.addAttribute("customerId", id);
		return "redirect://pizza/orderHistory";
	}
	
	@ModelAttribute
	public void populateFormWithData(Model model) {
		model.addAttribute("sizeList", pizzaService.populateSize());
		model.addAttribute("stateList", pizzaService.populateState());
		model.addAttribute("toppingList", pizzaService.populateTopping());
	}
}