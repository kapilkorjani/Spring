package com.carrentalsystem.services;

import java.util.List;

import com.carrentalsystem.model.Car;

public interface CarService {

	public boolean addCar(Car car);
	public boolean updateCar(Car car);
	public boolean deleteCar(Car car);
	public Car getCarById(int id);
	public List<Car> getAllCars();
	
}
