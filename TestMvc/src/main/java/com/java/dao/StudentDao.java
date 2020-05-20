package com.java.dao;

import java.util.List;

import com.java.model.Student;

public interface StudentDao {

	public void saveStudent(Student student);

	public void updateStudent(Student student);

	public void deleteStudent(Student student);

	public Student getStudentById(int id);

	public List<Student> getAllStudents();

	public Student getStudentByName(String name);
}
