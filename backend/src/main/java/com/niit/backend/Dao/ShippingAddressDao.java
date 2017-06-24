package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.ShippingAddress;





public interface ShippingAddressDao {
public boolean saveorupdate(ShippingAddress shipingAddress);
	
	public boolean delete(ShippingAddress ShipingAddress);
	
	public ShippingAddress get(String id);
	
	public List<ShippingAddress> list();

	public List<ShippingAddress> getaddbyuser(String u_id);

}
