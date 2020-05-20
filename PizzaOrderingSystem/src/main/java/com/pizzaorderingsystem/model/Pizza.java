package com.pizzaorderingsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Pizza {

	
	@Id @GeneratedValue
	private int pizzaId;
	private String pizzaName;
	private int pSmall;
	private int pMedium;
	private int pLarge;
	@OneToOne(mappedBy = "pizza")
	private Orders order;
	
	
	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public int getpSmall() {
		return pSmall;
	}
	public void setpSmall(int pSmall) {
		this.pSmall = pSmall;
	}
	public int getpMedium() {
		return pMedium;
	}
	public void setpMedium(int pMedium) {
		this.pMedium = pMedium;
	}
	public int getpLarge() {
		return pLarge;
	}
	public void setpLarge(int pLarge) {
		this.pLarge = pLarge;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	
	
	
}
