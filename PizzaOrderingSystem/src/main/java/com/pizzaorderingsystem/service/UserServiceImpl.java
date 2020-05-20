package com.pizzaorderingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pizzaorderingsystem.dao.UserDao;
import com.pizzaorderingsystem.dao.UserDaoImpl;
import com.pizzaorderingsystem.model.UserDetails;
import com.pizzaorderingsystem.util.PasswordManager;

@Repository
@Component
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public boolean addUser(UserDetails user) throws Exception {
		if(!userDao.chkUserByName(user.getName())) {
			String key = PasswordManager.getNewKey();
			String encryptedPassword = PasswordManager.getEncryptedPassword(user.getPassword(), key);
			user.setKey(key);
			user.setPassword(encryptedPassword);
			userDao.addUser(user);
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserDetails getUserByName(String name) {
		return userDao.getUserByName(name);
	}

	@Override
	public boolean loginUser(String name, String password) throws Exception {
		if(userDao.chkUserByName(name)) {
			UserDetails user =  userDao.getUserByName(name);
			String encryptedPassword = PasswordManager.getEncryptedPassword(password, user.getKey());
			if(encryptedPassword.equals(user.getPassword())) {
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}

	@Override
	public UserDetails getUserById(int id) {
		return userDao.getUserById(id);
	}

	
}
