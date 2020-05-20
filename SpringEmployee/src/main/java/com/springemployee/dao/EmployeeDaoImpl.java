package com.springemployee.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.springemployee.model.Employee;
@Repository
@Component
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();

	}

	@Override
	public Employee getEmployeeById(int id) {
		Session session = sessionFactory.openSession();	
		session.beginTransaction();
		Employee employee  = session.get(Employee.class, id);
		session.getTransaction().commit();
		session.close();
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(employee);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void deleteEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(employee);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public List<Employee> getAllEmployee() {
		Session session = sessionFactory.openSession();
		String hql = "from Employee";
		List<Employee> employees= (List<Employee>)session.createQuery(hql).list();
		session.close();
		return employees;
	}

	@Override
	public Employee getEmployeeByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean chkEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> getEmployeeByDesignation(String designation) {
		// TODO Auto-generated method stub
		return null;
	}

}
