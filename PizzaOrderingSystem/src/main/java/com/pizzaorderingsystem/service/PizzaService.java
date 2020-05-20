package com.pizzaorderingsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pizzaorderingsystem.model.Pizza;

@Service("pizzaService")
public interface PizzaService {

	public List<Pizza> getAllPizza();
	public boolean addPizza(Pizza pizza);
	public boolean updatePizza(Pizza pizza);
	public boolean deleteizza(Pizza pizza);
	public Pizza getPizzaById(int id);
}
