package com.carrentalsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.carrentalsystem.model.Car;
import com.carrentalsystem.model.Customer;

@Component
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	SessionFactory factory;
	
	@Override
	public void addCustomer(Customer customer) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(customer);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteCustomer(Customer customer) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.delete(customer);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = factory.openSession();
		Customer customer = session.get(Customer.class, id);
		session.close();
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		Session session = factory.openSession();
		String hql = "from Customer";
		List<Customer> customers = session.createQuery(hql).list();
		session.close();
		return customers;
	}

}
