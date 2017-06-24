package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.BillingAddress;

public interface BillingAddressDao {
public boolean saveorupdate(BillingAddress billingAddress);
	
	public boolean delete(BillingAddress billingAddress);
	
	public BillingAddress get(String id);
	
	public List<BillingAddress> list();
	public BillingAddress getByUser(String u_Id);
}