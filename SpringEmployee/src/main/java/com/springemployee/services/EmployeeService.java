package com.springemployee.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springemployee.model.Employee;

@Service("employeeService")
public interface EmployeeService {

	public void addEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int id);
}
