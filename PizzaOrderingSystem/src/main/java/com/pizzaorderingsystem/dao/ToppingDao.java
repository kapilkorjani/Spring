package com.pizzaorderingsystem.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pizzaorderingsystem.model.Topping;

@Service
@Component
public interface ToppingDao {

	
	public void addTopping(Topping topping);
	public void updateTopping(Topping topping);
	public void deleteTopping(Topping topping);
	public Topping getToppingById(int id);
	public Topping getToppingByName(String name);
	public List<Topping> getAllToppings();
	
}
