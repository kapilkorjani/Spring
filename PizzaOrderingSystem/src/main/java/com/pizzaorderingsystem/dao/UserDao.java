package com.pizzaorderingsystem.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pizzaorderingsystem.model.UserDetails;


@Service
@Component
public interface UserDao {

	
	public void addUser(UserDetails user);
	public void updateUser(UserDetails user);
	public void deleteUser(UserDetails user);
	public UserDetails getUserByName(String name);
	public UserDetails getUserById(int id);
	public boolean chkUserByName(String name);
	public List<UserDetails> getAllUsers();
	
	
}
