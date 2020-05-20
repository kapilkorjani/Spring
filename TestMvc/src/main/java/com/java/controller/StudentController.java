package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.model.Student;
import com.java.services.StudentServiceImpl;

@Controller
public class StudentController {

	@Autowired
	StudentServiceImpl studentService;
	
	@RequestMapping("/add")
	public ModelAndView addStudent(@RequestParam String name) {
		ModelAndView mv  = new ModelAndView("index");
		Student student = new Student();
		student.setName(name);
		studentService.addStudent(student);
		return mv;
	}
	
	@RequestMapping("/get")
	public ModelAndView getSudents() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("students", studentService.getAllStudents());
		System.out.println(studentService.getAllStudents());
		System.out.println(studentService.getStudentById(1));
		addStudent("Amit");
		return mv;
	}
	
}
