package com.pizzaorderingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pizzaorderingsystem.dao.ToppingDao;
import com.pizzaorderingsystem.model.Topping;

@Repository
@Component
public class ToppingServiceImpl implements ToppingService{

	@Autowired
	private ToppingDao toppingDao;

	@Override
	public List<Topping> getAllToppings() {
		// TODO Auto-generated method stub
		return toppingDao.getAllToppings();
	}

	@Override
	public boolean addTopping(Topping topping) {
		if(toppingDao.getToppingByName(topping.getName())==null) {
			toppingDao.addTopping(topping);
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean updateTopping(Topping topping) {
		if(toppingDao.getToppingByName(topping.getName())!=null) {
			toppingDao.updateTopping(topping);
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean deletetopping(Topping topping) {
		if(toppingDao.getToppingByName(topping.getName())!=null) {
			toppingDao.deleteTopping(topping);
			return true;
		}
		else
			return false;
	}

	@Override
	public Topping getToppingById(int id) {
		return toppingDao.getToppingById(id);
	}
	
	
}
