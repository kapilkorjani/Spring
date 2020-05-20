package com.springemployee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.springemployee.dao.EmployeeDao;
import com.springemployee.dao.EmployeeDaoImpl;
import com.springemployee.model.Employee;

//@Service("employeeService")
@Repository
@Component
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
		
	}
	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}
	@Override
	public void deleteEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);
	}
	@Override
	public List<Employee> getAllEmployees(){
		return employeeDao.getAllEmployee();
	}
	@Override
	public Employee getEmployeeById(int id) {
		return employeeDao.getEmployeeById(id);
	}
}
