package com.carrentalsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.carrentalsystem.model.Car;

@Component
@Repository
@Transactional
public class CarDaoImpl implements CarDao{

	@Autowired
	SessionFactory factory;
	
	@Override
	public void addCar(Car car) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(car);
		session.getTransaction().commit();
		session.close();	
	}

	@Override
	public void updateCar(Car car) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(car);
		session.getTransaction().commit();
		session.close();	
	}

	@Override
	public void deleteCar(Car car) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.delete(car);
		session.getTransaction().commit();
		session.close();	
	}

	@Override
	public Car getCarById(int id) {
		Session session = factory.openSession();
		Car car = session.get(Car.class, id);
		session.close();
		return car;
	}

	@Override
	public List<Car> getAllCars() {
		Session session = factory.openSession();
		String hql = "from Car";
		List<Car> cars = session.createQuery(hql).list();
		session.close();
		return cars;
	}

	
	
}
