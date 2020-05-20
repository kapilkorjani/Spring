package com.pizzaorderingsystem.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Topping {

	@Id @GeneratedValue
	private int toppingId;
	private String name;
	private int price;
	@ManyToMany
	private List<Orders> orders;
	
	
	public int getToppingId() {
		return toppingId;
	}
	public void setToppingId(int toppingId) {
		this.toppingId = toppingId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	
	
}
