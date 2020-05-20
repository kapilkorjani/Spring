package com.springemployee.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springemployee.model.Employee;


@Service
@Component
public interface EmployeeDao {

	public void addEmployee(Employee employee);
	
	public Employee getEmployeeById(int id);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployeeByName();
	
	public boolean chkEmployeeByName(String name);
	
	public List<Employee> getEmployeeByDesignation(String designation);
	
}
