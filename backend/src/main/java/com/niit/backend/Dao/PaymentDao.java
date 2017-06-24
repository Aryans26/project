package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.Payment;



public interface PaymentDao  {
	public boolean saveorupdate(Payment payment);
	
	public boolean delete(Payment payment);
	
	public Payment get(String id);
	
	public List<Payment> list();

}
