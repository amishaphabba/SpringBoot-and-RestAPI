package com.example.demo.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offers {
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int offer_id;
	int product_id;
	int discount;
	LocalDate start_date;
	LocalDate end_date;
	Offers(){}
	
	public Offers(int offer_id, int product_id, int discount, LocalDate start_date, LocalDate end_date) {
		super();
		this.offer_id = offer_id;
		this.product_id = product_id;
		this.discount = discount;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	
	public int getOffer_id() {
		return offer_id;
	}
	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	

	@Override
	public String toString() {
		return "Offers [offer_id=" + offer_id + ", product_id=" + product_id + ", discount=" + discount
				+ ", start_date=" + start_date + ", end_date=" + end_date + "]\n";
	}

}
