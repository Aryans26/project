package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.CartItem;


public interface CartItemsDao {
public boolean saveorupdate(CartItem cartItem);
	
	public boolean deletebyId(String id);
	
	public CartItem get(String id);
	
	public List<CartItem> list();

	public List<CartItem> getlist(String  cart_Id);
	public List<CartItem> getlistbyproId(String p_id);
	public CartItem getlistall(String CartId, String pro);

	public boolean delete(CartItem cartItem);
}
