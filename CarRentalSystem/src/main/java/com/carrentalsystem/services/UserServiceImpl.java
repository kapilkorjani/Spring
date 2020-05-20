package com.carrentalsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.carrentalsystem.dao.UserDao;
import com.carrentalsystem.model.User;

@Service
@Component
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public User getUserByName(String name) {
		return userDao.getUserByName(name);
	}

	@Override
	public boolean loginUser(String name, String password) {
		if(userDao.chkUserByName(name)) {
			User user =  userDao.getUserByName(name);
//			String encryptedPassword = PasswordManager.getEncryptedPassword(password, user.getKey());
			if(password.equals(user.getPassword())) {
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}

}
