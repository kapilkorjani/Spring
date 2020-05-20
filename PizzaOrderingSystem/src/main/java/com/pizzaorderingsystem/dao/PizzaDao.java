package com.pizzaorderingsystem.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pizzaorderingsystem.model.Pizza;

@Service
@Component
public interface PizzaDao {

	public void addPizza(Pizza pizza);
	public void updatePizza(Pizza pizza);
	public void deletePizza(Pizza  pizza);
	public Pizza getPizzaById(int id);
	public Pizza getPizzaByName(String name);
	public List<Pizza> getAllPizza();
	
}
