package com.pizzaorderingsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pizzaorderingsystem.model.Topping;

@Service("pizzaService")
public interface ToppingService {

	public List<Topping> getAllToppings();
	public boolean addTopping(Topping topping);
	public boolean updateTopping(Topping topping);
	public boolean deletetopping(Topping topping);
	public Topping getToppingById(int id);
}
