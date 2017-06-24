package com.niit.backend.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class OrderItems {
	@Id
	private String OrderItem_id;
	private String P_id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Order_id")
	private Order order;
	
	public OrderItems(){
		this.OrderItem_id="ORDITM"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getOrderItem_id() {
		return OrderItem_id;
	}
	public void setOrderItem_id(String orderItem_id) {
		OrderItem_id = orderItem_id;
	}
	public String getP_id() {
		return P_id;
	}
	public void setP_id(String p_id) {
		P_id = p_id;
	}
	
	

}
