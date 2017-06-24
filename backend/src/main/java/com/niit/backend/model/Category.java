package com.niit.backend.model;


import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table
public class Category 
{
	@Id
	private String C_id;
	private String C_name;

	
	@OneToMany(mappedBy="category")
	private List<Product> product;

	public Category(){
		this.C_id="CAT"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public String getC_id() {
		return C_id;
	}

	public void setC_id(String c_id) {
		C_id = c_id;
	}

	public String getC_name() {
		return C_name;
	}

	public void setC_name(String c_name) {
		C_name = c_name;
	}


	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	

}
