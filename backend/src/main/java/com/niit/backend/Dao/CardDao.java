package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.Card;


public interface CardDao {
public boolean saveorupdate(Card card);
	
	public boolean delete(Card card);
	
	public Card get(String id);
	
	public List<Card> list();
	
	public List<Card> getcardbyuser(String u_Id);

}
