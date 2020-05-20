package com.carrentalsystem.dao;

import java.util.List;

import com.carrentalsystem.model.Car;

public interface CarDao {

	public void addCar(Car car);
	public void updateCar(Car car);
	public void deleteCar(Car car);
	public Car getCarById(int id);
	public List<Car> getAllCars();
}
