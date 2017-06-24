package com.niit.backend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Cart {
	@Id
	private String Cart_Id;
	private double Grand_total=00.0;
	private int Total_item=0;
	
	@OneToMany(mappedBy="cart" , fetch=FetchType.EAGER)
	private List<CartItem> cartItem;

	public Cart(){
		this.Cart_Id="CART"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public String getCart_Id() {
		return Cart_Id;
	}

	public void setCart_Id(String cart_Id) {
		Cart_Id = cart_Id;
	}

	public double getGrand_total() {
		return Grand_total;
	}

	public void setGrand_total(double grand_total) {
		Grand_total = grand_total;
	}

	public int getTotal_item() {
		return Total_item;
	}

	public void setTotal_item(int total_item) {
		Total_item = total_item;
	}

	public List<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}
	
	
}
