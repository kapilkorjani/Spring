package com.carrentalsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.carrentalsystem.dao.CarDaoImpl;
import com.carrentalsystem.model.Car;

@Service
@Component
public class CarServiceImpl implements CarService{

	@Autowired
	CarDaoImpl carDao;
	
	@Override
	public boolean addCar(Car car) {
		carDao.addCar(car);
		return true;
	}

	@Override
	public boolean updateCar(Car car) {
		carDao.updateCar(car);
		return true;
	}

	@Override
	public boolean deleteCar(Car car) {
		carDao.deleteCar(car);
		return true;
	}

	@Override
	public Car getCarById(int id) {
		return carDao.getCarById(id);
	}

	@Override
	public List<Car> getAllCars() {
		return carDao.getAllCars();
	}

}
