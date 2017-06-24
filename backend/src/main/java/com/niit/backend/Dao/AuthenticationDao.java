package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.Authentication;

public interface AuthenticationDao {
public boolean saveorupdate(Authentication authentication);
	
	public boolean delete(Authentication authentication);
	
	public Authentication get(String id);
	
	public List<Authentication> list();

}
