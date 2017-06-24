package com.niit.backend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Payment {
	@Id
	private String Payment_id;
	private String Payment_method;
	private String Payment_Status;
	
	public Payment(){
		this.Payment_id="PAY"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getPayment_id() {
		return Payment_id;
	}
	public void setPayment_id(String payment_id) {
		Payment_id = payment_id;
	}
	public String getPayment_method() {
		return Payment_method;
	}
	public void setPayment_method(String payment_method) {
		Payment_method = payment_method;
	}
	public String getPayment_Status() {
		return Payment_Status;
	}
	public void setPayment_Status(String payment_Status) {
		Payment_Status = payment_Status;
	}
	
}
