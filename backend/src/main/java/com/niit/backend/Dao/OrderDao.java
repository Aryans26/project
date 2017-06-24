package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.Order;


public interface OrderDao {
public boolean saveorupdate(Order order);
	
	public boolean delete(Order order);
	
	public Order get(String id);
	
	public List<Order> list();


}
