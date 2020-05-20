package com.pizzaorderingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pizzaorderingsystem.dao.PizzaDao;
import com.pizzaorderingsystem.model.Pizza;

@Repository
@Component
public class PizzaServiceImpl implements PizzaService{

	@Autowired
	private PizzaDao pizzaDao;

	@Override
	public List<Pizza> getAllPizza() {
		return pizzaDao.getAllPizza();
	}

	@Override
	public boolean addPizza(Pizza pizza) {
		if(pizzaDao.getPizzaByName(pizza.getPizzaName())==null) {
			pizzaDao.addPizza(pizza);
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean updatePizza(Pizza pizza) {
		if(pizzaDao.getPizzaByName(pizza.getPizzaName())!=null) {
			pizzaDao.updatePizza(pizza);
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean deleteizza(Pizza pizza) {
		if(pizzaDao.getPizzaByName(pizza.getPizzaName())!=null) {
			pizzaDao.deletePizza(pizza);
			return true;
		}
		else
			return false;
	}

	@Override
	public Pizza getPizzaById(int id) {
		// TODO Auto-generated method stub
		return pizzaDao.getPizzaById(id);
	}

	
	
	
	
}
