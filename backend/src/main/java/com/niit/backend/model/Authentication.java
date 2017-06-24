package com.niit.backend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class Authentication {
	@Id
	private String Role_id;
	private String ROLE_NAME="ROLE_USER";
	private String username;
	public Authentication()
	{
		this.Role_id="ROLE"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getRole_id() {
		return Role_id;
	}
	public void setRole_id(String role_id) {
		Role_id = role_id;
	}
	
	public String getROLE_NAME() {
		return ROLE_NAME;
	}
	public void setROLE_NAME(String rOLE_NAME) {
		ROLE_NAME = rOLE_NAME;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}
