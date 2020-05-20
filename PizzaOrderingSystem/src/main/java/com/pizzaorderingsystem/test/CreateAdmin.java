package com.pizzaorderingsystem.test;

import org.springframework.beans.factory.annotation.Autowired;

import com.pizzaorderingsystem.dao.UserDao;
import com.pizzaorderingsystem.dao.UserDaoImpl;
import com.pizzaorderingsystem.model.UserDetails;
import com.pizzaorderingsystem.util.PasswordManager;

public class CreateAdmin {

	
	
	public static void main(String args[]) throws Exception {
		UserDaoImpl userDao = new UserDaoImpl();
		UserDetails user = new UserDetails();
		user.setName("admin");
		String key = PasswordManager.getNewKey();
		String password  = PasswordManager.getEncryptedPassword("admin", key);
		user.setKey(key);
		user.setPassword(password);
		user.setType("admin");
		user.setEmail("admin@gmail.com");
		userDao.addUser(user);
		
		
		
	}
}
