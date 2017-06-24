package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.Users;

public interface UsersDao {
	public boolean saveorupdate(Users users);
	
	public boolean delete(String users);
	
	public Users get(String id);
	
	public List<Users> list();
	
	public Users getUseremail(String email);
	
	public Users isvalid(String email,String password);

}
