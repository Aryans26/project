package com.niit.backend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;



@Entity
@Component
@Table
public class Card {
	@Id
	private String Card_id;
	private String Card_no;
	private String Holder_name;
	private int Exp_date;
	private int Exp_month;
	private int Exp_year;
	
	@ManyToOne
	@JoinColumn(name="u_Id")
	private Users user;
	
	public Card(){
		this.Card_id="CARD"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public int getExp_month() {
		return Exp_month;
	}
	public void setExp_month(int exp_month) {
		Exp_month = exp_month;
	}
	public int getExp_year() {
		return Exp_year;
	}
	public void setExp_year(int exp_year) {
		Exp_year = exp_year;
	}
	public String getCard_id() {
		return Card_id;
	}
	public void setCard_id(String card_id) {
		Card_id = card_id;
	}
	public String getCard_no() {
		return Card_no;
	}
	public void setCard_no(String card_no) {
		Card_no = card_no;
	}
	public String getHolder_name() {
		return Holder_name;
	}
	public void setHolder_name(String holder_name) {
		Holder_name = holder_name;
	}
	public int getExp_date() {
		return Exp_date;
	}
	public void setExp_date(int exp_date) {
		Exp_date = exp_date;
	}
	

}
