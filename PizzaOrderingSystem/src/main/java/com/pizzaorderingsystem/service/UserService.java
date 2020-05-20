package com.pizzaorderingsystem.service;

import org.springframework.stereotype.Service;

import com.pizzaorderingsystem.model.UserDetails;

@Service("userService")
public interface UserService {

	public boolean addUser(UserDetails user) throws Exception;
	public boolean updateUser(UserDetails user);
	public UserDetails getUserByName(String name);
	public boolean loginUser(String name,String password) throws Exception;
	public UserDetails getUserById(int id);
}
