package edu.wccnet.emeyer.hibernate;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "street")
	private String steet;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zip")
	private String zip;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<PizzaOrder> pizzaOrderList = new ArrayList<PizzaOrder>();
	
	public void addOrder(PizzaOrder pizzaOrder) {
		pizzaOrderList.add(pizzaOrder);
		pizzaOrder.setCustomer(this);
	}
	
	public void removeOrder(PizzaOrder pizzaOrder) {
		pizzaOrderList.remove(pizzaOrder);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<PizzaOrder> getPizzaOrderList() {
		return pizzaOrderList;
	}

	public void setPizzaOrderList(List<PizzaOrder> pizzaOrderList) {
		this.pizzaOrderList = pizzaOrderList;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSteet() {
		return steet;
	}

	public void setSteet(String steet) {
		this.steet = steet;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", steet=" + steet
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
	public Customer() {
		
	}

	public Customer(String firstName, String lastName, String steet, String city, String state, String zip) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.steet = steet;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	
}
