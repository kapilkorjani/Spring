package com.carrentalsystem.services;

import java.util.List;

import com.carrentalsystem.model.Customer;

public interface CustomerService {

	public boolean addCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public boolean deleteCustomer(Customer customer);
	public Customer getCustomerById(int id);
	public List<Customer> getAllCustomers();
	
}
