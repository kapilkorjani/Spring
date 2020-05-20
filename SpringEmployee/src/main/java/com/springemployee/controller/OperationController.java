package com.springemployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springemployee.model.Employee;
import com.springemployee.services.EmployeeService;

@Controller
public class OperationController {

	@Autowired
	private Employee emp /*= new Employee()*/;
	@Autowired
	private EmployeeService ems;
	
	
//	ApplicationContext ap = new ClassPathXmlApplicationContext("employee-servlet.xml");
	@RequestMapping("/addEmployee")
	public ModelAndView addEmployee(@RequestParam("ename") String name, @RequestParam("salary") int salary,@RequestParam("designation") String designation) {
		ModelAndView mv  = new ModelAndView();
//		Employee emp = ap.getBean("employee",Employee.class);
		emp.setName(name);
		emp.setDesignation(designation);
		emp.setSalary(salary);
//		EmployeeService ems = ap.getBean("employeeService",EmployeeService.class);
		ems.addEmployee(emp);
		mv.setViewName("employeeDetails");
		return mv;
	}
	@RequestMapping("/updateDeleteEmployee")
	public ModelAndView updateDeleteEmployee(@RequestParam("ename") String name, @RequestParam("salary") int salary,@RequestParam("designation") String designation,@RequestParam("option") String option,@RequestParam("id") int id) {
		ModelAndView mv  = new ModelAndView();
//		Employee emp = ap.getBean("employee",Employee.class);
//		EmployeeService ems = ap.getBean("employeeService",EmployeeService.class);
		if(option.equals("update")) {
			emp = ems.getEmployeeById(id);
			emp.setName(name);
			emp.setDesignation(designation);
			emp.setSalary(salary);
			ems.updateEmployee(emp);
		}
		else {
			emp = ems.getEmployeeById(id);
			ems.deleteEmployee(emp);
		}
		mv.setViewName("employeeDetails");
		return mv;
	}
	@RequestMapping("/employeeDetails")
	public ModelAndView employeeDetails() {
		ModelAndView mv  = new ModelAndView();
//		EmployeeService ems = ap.getBean("employeeService",EmployeeService.class);
		List<Employee> employees = null;
		employees = ems.getAllEmployees();
		mv.addObject("employees",employees);
		mv.setViewName("index.jsp");
		
		return mv;
	}
}
