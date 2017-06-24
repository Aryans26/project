package com.niit.backend.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table
public class Users {
	@Id
	private String U_id;
	private String U_name;
	private String U_phoneno;
	private String U_pwd;
	private String Role="ROLE_USER";
	private String U_email;
	
	@OneToOne
	@JoinColumn(name="Cart_Id")
	private Cart cart;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="Bill_id")
	private BillingAddress billingAddress;

	public Users() {
		// TODO Auto-generated constructor stub
		this.U_id="USER"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
	public String getRole() {
		return Role;
	}


	public void setRole(String role) {
		Role = role;
	}


	public String getU_id() {
		return U_id;
	}

	public void setU_id(String u_id) {
		U_id = u_id;
	}

	public String getU_name() {
		return U_name;
	}

	public void setU_name(String u_name) {
		U_name = u_name;
	}

	public String getU_phoneno() {
		return U_phoneno;
	}

	public void setU_phoneno(String u_phoneno) {
		U_phoneno = u_phoneno;
	}

	public String getU_pwd() {
		return U_pwd;
	}

	public void setU_pwd(String u_pwd) {
		U_pwd = u_pwd;
	}

	public String getU_email() {
		return U_email;
	}

	public void setU_email(String u_email) {
		U_email = u_email;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	
	
}
