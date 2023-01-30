package edu.wccnet.emeyer.pizzaOrder.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "pizza")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "topping")
	private String toppings;
	
	@ManyToOne( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "order_id")
	private Order order;

	
	public Pizza(String size, String toppings) {
		super();
		this.size = size;
		this.toppings = toppings;
	}


	@Override
	public String toString() {
		return "Pizza [id=" + id + ", size=" + size + ", toppings=" + toppings + ",]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getToppings() {
		return toppings;
	}


	public void setToppings(String toppings) {
		this.toppings = toppings;
	}


	public Pizza() {
		
	}


	public void setOrder(Order order) {
		 this.order = order;
		
	}
	
	

}
