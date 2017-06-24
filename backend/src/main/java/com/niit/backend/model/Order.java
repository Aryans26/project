package com.niit.backend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="Orders")
@Component
public class Order {
	@Id
	private String Order_id;
	private double Grand_total;
	private String Order_date;
	private String Order_time;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="Bill_id")
	private BillingAddress billingAddress;
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="Ship_id")
	private ShippingAddress shipingAddress;
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="Payment_id")
	private Payment payment;
	
	@OneToOne
	@JoinColumn(name="U_id")
	private Users users;
	
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderItems> orderItems;
	
	public Order(){
		this.Order_id="ORDR"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public ShippingAddress getShipingAddress() {
		return shipingAddress;
	}
	public void setShipingAddress(ShippingAddress shipingAddress) {
		this.shipingAddress = shipingAddress;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Users getUser() {
		return users;
	}
	public void setUser(Users users) {
		this.users = users;
	}

	
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	public String getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(String order_id) {
		Order_id = order_id;
	}
	public double getGrand_total() {
		return Grand_total;
	}
	public void setGrand_total(double grand_total) {
		Grand_total = grand_total;
	}
	public String getOrder_date() {
		return Order_date;
	}
	public void setOrder_date(String order_date) {
		Order_date = order_date;
	}
	public String getOrder_time() {
		return Order_time;
	}
	public void setOrder_time(String order_time) {
		Order_time = order_time;
	}
	
}
