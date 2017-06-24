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

public class Supplier 
{
	@Id
	private String S_id;
	private String S_name;
	private String S_num;
	
	
	public void setS_num(String s_num) {
		S_num = s_num;
	}
	@OneToMany(mappedBy="supplier")
	private List<Product> product;
	
	public Supplier() {
		// TODO Auto-generated constructor stub
		this.S_id="SUPP"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public String getS_id() {
		return S_id;
	}
	public void setS_id(String string) {
		S_id = string;
	}
	public String getS_name() {
		return S_name;
	}
	public void setS_name(String s_name) {
		S_name = s_name;
	}

	public String getS_num() {
		return S_num;
	}
	

}
