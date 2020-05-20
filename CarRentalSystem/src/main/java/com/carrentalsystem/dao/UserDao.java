package com.carrentalsystem.dao;

import com.carrentalsystem.model.User;

public interface UserDao {

	public User getUserById(int id);
	
	public User getUserByName(String name);

	boolean chkUserByName(String name);
	
}
