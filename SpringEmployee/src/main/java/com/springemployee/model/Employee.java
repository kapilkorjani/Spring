package com.springemployee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Employee {

	@Id @GeneratedValue
	private int empId;
	private String name;
	private int salary;
	private String designation;
	
	
	
	public Employee() {
	}

	public Employee(int empId, String name, int salary, String designation) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
		
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + ", designation=" + designation
				+ "]";
	}
	
	
}
