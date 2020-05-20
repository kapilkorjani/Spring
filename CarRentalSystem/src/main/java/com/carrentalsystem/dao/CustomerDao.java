package com.carrentalsystem.dao;

import java.util.List;

import com.carrentalsystem.model.Customer;

public interface CustomerDao {

	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	public Customer getCustomerById(int id);
	public List<Customer> getAllCustomers();
	
}
