package com.pizzaorderingsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pizzaorderingsystem.model.UserDetails;


@Repository
@Component
public class UserDaoImpl implements UserDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void addUser(UserDetails user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateUser(UserDetails user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteUser(UserDetails user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public UserDetails getUserByName(String name) {
		String hql = "from UserDetails where name =:name";
		Session session = sessionFactory.openSession();
//		session.beginTransaction();
		List<UserDetails> users = session.createQuery(hql).setParameter("name", name).list();
		UserDetails user = users.size() != 0 ? users.get(0):null;
//		session.getTransaction().commit();
		session.close();
		return user;
	}

	@Override
	public UserDetails getUserById(int id) {
		Session session = sessionFactory.openSession();
		UserDetails user = session.get(UserDetails.class,id);
		session.close();
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean chkUserByName(String name) {
		String hql = "from UserDetails where name =:name";
		Session session = sessionFactory.openSession();
		List<UserDetails> users = session.createQuery(hql).setParameter("name", name).list();
		boolean result = users.size() != 0 ? true:false;
		session.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetails> getAllUsers() {
		String hql = "from UserDetails";
		Session session = sessionFactory.openSession();
		List<UserDetails> users = session.createQuery(hql).list();
		session.close();
		return users;
	}

	
}
