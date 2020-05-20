package com.pizzaorderingsystem.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pizzaorderingsystem.model.Orders;
import com.pizzaorderingsystem.model.UserDetails;

@Service
@Component
public interface OrderDao {

	
	public void addOrder(Orders order);
	public void updateOrder(Orders order);
	public void deleteOrder(Orders order);
	public Orders getOrderById(int id);
	public List<Orders> getAllOrders();
	public List<Orders> getAllOrdersByUser(UserDetails user);
 	
}
