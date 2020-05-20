package com.pizzaorderingsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pizzaorderingsystem.model.Orders;
import com.pizzaorderingsystem.model.UserDetails;

@Repository
@Component
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addOrder(Orders order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateOrder(Orders order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(order);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void deleteOrder(Orders order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(order);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Orders getOrderById(int id) {
		Session session = sessionFactory.openSession();
		Orders order = session.get(Orders.class, id);
		session.close();
		return order;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getAllOrders() {
		String hql = "from Orders";
		Session session = sessionFactory.openSession();
		List<Orders> orders = session.createQuery(hql).list();
		session.close();
		return orders;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getAllOrdersByUser(UserDetails user) {
		String hql = "from Orders where customer =:customer";
		Session session = sessionFactory.openSession();
		List<Orders> orders = session.createQuery(hql).setParameter("customer", user).list();
		session.close();
		return orders;
	}
	
	
}
