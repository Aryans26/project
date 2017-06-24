package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.Category;

public interface CategoryDao 
{
	public boolean saveOrUpdate(Category category);
	public boolean delete(Category category);
	public Category getCategory(String id);
	public List<Category> list();
	public Category getCategoryp(String id);
}
