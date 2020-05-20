package com.carrentalsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.carrentalsystem.model.User;

@Repository
@Component
public class UserDaoImpl implements UserDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public User getUserById(int id) {
		Session session = sessionFactory.openSession();
		User user = session.get(User.class, id);
		session.close();
		return user;
	}

	@Override
	@SuppressWarnings("unchecked")
	public User getUserByName(String name) {
		String hql = "from User where name =:name";
		Session session = sessionFactory.openSession();
		List<User> users = session.createQuery(hql).setParameter("name", name).list();
		User user = users.size() != 0 ? users.get(0):null;
		session.close();
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean chkUserByName(String name) {
		String hql = "from User where name =:name";
		Session session = sessionFactory.openSession();
		List<User> users = session.createQuery(hql).setParameter("name", name).list();
		boolean result = users.size() != 0 ? true:false;
		session.close();
		return result;
	}
}
