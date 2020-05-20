package com.java.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.model.Student;

@Component
@Repository
@Transactional
public class StudentDaoImpl implements StudentDao{

	@Autowired
	SessionFactory factory;
	
	
	@Override
	public void saveStudent(Student student) {
		SessionSingleton.getSession().beginTransaction();
		SessionSingleton.getSession().save(student);
		SessionSingleton.getSession().getTransaction().commit();
	}

	@Override
	public void updateStudent(Student student) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(student);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void deleteStudent(Student student) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.delete(student);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		Session session = factory.openSession();
		String hql = "from Student";
		List<Student> students = session.createQuery(hql).list();
		session.close();
		return students;
	}

	@Override
	public Student getStudentByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
