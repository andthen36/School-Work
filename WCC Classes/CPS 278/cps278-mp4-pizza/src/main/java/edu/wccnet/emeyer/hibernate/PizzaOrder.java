package edu.wccnet.emeyer.hibernate;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza_order")
public class PizzaOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "pizzaOrder", cascade = CascadeType.ALL)
	private List<Pizza> pizzaList = new ArrayList<Pizza>();
	
	public PizzaOrder() {
	
	}

	public void addPizza(Pizza pizza) {
		pizzaList.add(pizza);
		pizza.setPizzaOrder(this);
	}
	
	public void removePizza(Pizza pizza) {
		pizzaList.remove(pizza);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Pizza> getPizzaList() {
		return pizzaList;
	}

	public void setPizzaList(List<Pizza> pizzaList) {
		this.pizzaList = pizzaList;
	}

	@Override
	public String toString() {
		return "PizzaOrder [id=" + id + ", customer=" + customer + ", pizzaList=" + pizzaList + "]";
	}
	
	
	
}
