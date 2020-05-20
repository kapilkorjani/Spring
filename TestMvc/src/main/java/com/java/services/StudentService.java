package com.java.services;

import java.util.List;

import com.java.model.Student;

public interface StudentService {

	public void addStudent(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(Student student);
	public List<Student> getAllStudents();
	public Student getStudentById(int id);
}
