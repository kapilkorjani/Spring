package com.carrentalsystem.services;

import com.carrentalsystem.model.User;

public interface UserService {

	public User getUserById(int id);
	
	public User getUserByName(String name);

	public boolean loginUser(String name, String password);
	
	
}
