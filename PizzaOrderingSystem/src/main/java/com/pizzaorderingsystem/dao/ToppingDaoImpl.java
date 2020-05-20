package com.pizzaorderingsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pizzaorderingsystem.model.Topping;

@Repository
@Component
public class ToppingDaoImpl implements ToppingDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addTopping(Topping topping) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(topping);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void updateTopping(Topping topping) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(topping);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteTopping(Topping topping) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(topping);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Topping getToppingById(int id) {
		Session session = sessionFactory.openSession();
		Topping topping = session.get(Topping.class, id);
		session.close();
		return topping;
	}

	@Override
	public Topping getToppingByName(String name) {
		String hql = "from Topping where name =:name";
		Session session =sessionFactory.openSession();
		List<Topping> toppings = session.createQuery(hql).setParameter("name", name).list();
		session.close();
		Topping topping = toppings.size() !=0?toppings.get(0):null;
		return topping;
	}

	@Override
	public List<Topping> getAllToppings() {
		String hql = "from Topping";
		Session session =sessionFactory.openSession();
		List<Topping> toppings = session.createQuery(hql).list();
		session.close();
		return toppings;
	}

}
