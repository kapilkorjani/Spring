package com.pizzaorderingsystem.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Orders {

	
	@Id @GeneratedValue
	private int orderId;
	@OneToOne(fetch = FetchType.EAGER)
	private UserDetails customer;
	@OneToOne(fetch = FetchType.EAGER)
	private Pizza pizza;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Topping> toppings;
	private String pizzaSize;
	private int totalCost;
	private String status;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public UserDetails getCustomer() {
		return customer;
	}
	public void setCustomer(UserDetails customer) {
		this.customer = customer;
	}
	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	public List<Topping> getToppings() {
		return toppings;
	}
	public void setToppings(List<Topping> toppings) {
		this.toppings = toppings;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPizzaSize() {
		return pizzaSize;
	}
	public void setPizzaSize(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}
	
	 	
	
	
}
