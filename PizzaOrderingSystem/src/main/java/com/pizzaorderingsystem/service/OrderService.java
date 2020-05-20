package com.pizzaorderingsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pizzaorderingsystem.model.Orders;
import com.pizzaorderingsystem.model.UserDetails;

@Service("orderService")
public interface OrderService {

	public void addOrder(Orders order);
	public boolean updateOrder(Orders order);
	public boolean deleteOrder(Orders order);
	public List<Orders> getAllOrders();
	public List<Orders> getAllOrdersByUser(UserDetails user);
	public Orders getOrderById(int id);
}
	