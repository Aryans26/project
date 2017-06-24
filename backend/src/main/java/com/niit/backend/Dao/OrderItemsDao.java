package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.Order;
import com.niit.backend.model.OrderItems;


public interface OrderItemsDao {
public boolean saveorupdate(OrderItems orderItems);
	
	public boolean delete(OrderItems orderItems);
	
	public OrderItems get(String id);
	public List<OrderItems> getOrderItemsbyOrder(String order_id);
	public List<OrderItems> list();


}
