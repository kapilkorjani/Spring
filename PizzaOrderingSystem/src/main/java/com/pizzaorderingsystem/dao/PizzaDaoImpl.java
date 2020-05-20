package com.pizzaorderingsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pizzaorderingsystem.model.Pizza;

@Repository
@Component
public class PizzaDaoImpl implements PizzaDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addPizza(Pizza pizza) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(pizza);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updatePizza(Pizza pizza) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(pizza);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deletePizza(Pizza pizza) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(pizza);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Pizza getPizzaById(int id) {
		Session session = sessionFactory.openSession();
		Pizza pizza =  session.get(Pizza.class, id);
		session.close();
		return pizza;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pizza getPizzaByName(String name) {
		String hql = "from Pizza where pizzaName =:name";
		Session session = sessionFactory.openSession();
		List<Pizza> pizzas = session.createQuery(hql).setParameter("name",name).list();
		session.close();
		Pizza pizza = pizzas.size() !=0?pizzas.get(0):null;
		return pizza;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pizza> getAllPizza(){
		String hql = "from Pizza";
		Session session = sessionFactory.openSession();
		List<Pizza> pizzas = session.createQuery(hql).list();
		session.close();
		return pizzas;
	}

}
