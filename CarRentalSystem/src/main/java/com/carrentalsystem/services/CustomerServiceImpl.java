package com.carrentalsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.carrentalsystem.dao.CustomerDaoImpl;
import com.carrentalsystem.model.Customer;

@Service
@Component
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDaoImpl customerDao;
	
	@Override
	public boolean addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
		return true;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
		return true;
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
		return true;
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

}
