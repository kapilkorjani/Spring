package com.java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.StudentDaoImpl;
import com.java.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDaoImpl studentDao;

	@Override
	public void addStudent(Student student) {
		studentDao.saveStudent(student);
	}

	@Override
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}

	@Override
	public void deleteStudent(Student student) {
		studentDao.deleteStudent(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}

	
}
