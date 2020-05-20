package com.pizzaorderingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pizzaorderingsystem.dao.OrderDao;
import com.pizzaorderingsystem.model.Orders;
import com.pizzaorderingsystem.model.UserDetails;

@Service
@Component
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;

	@Override
	public void addOrder(Orders order) {
		orderDao.addOrder(order);
	}

	@Override
	public boolean updateOrder(Orders order) {
		if(orderDao.getOrderById(order.getOrderId()) != null) {
			orderDao.updateOrder(order);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteOrder(Orders order) {
		if(orderDao.getOrderById(order.getOrderId()) != null) {
			orderDao.deleteOrder(order);
			return true;
		}
		return false;
		
	}

	@Override
	public List<Orders> getAllOrders() {
		return orderDao.getAllOrders();
	}

	@Override
	public List<Orders> getAllOrdersByUser(UserDetails user) {
		return orderDao.getAllOrdersByUser(user);
	}

	@Override
	public Orders getOrderById(int id) {
		// TODO Auto-generated method stub
		return orderDao.getOrderById(id);
	}
}
