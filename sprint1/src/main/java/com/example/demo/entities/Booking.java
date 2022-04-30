package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int bill_no;
	int user_id;
	String products_id;
	float total;
	
	public Booking(int bill_no, int user_id, String products_id, float total) {
		super();
		this.bill_no = bill_no;
		this.user_id = user_id;
		this.products_id = products_id;
		this.total = total;
	}
	Booking(){}
	public int getBill_no() {
		return bill_no;
	}
	public void setBill_no(int bill_no) {
		this.bill_no = bill_no;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getProducts_id() {
		return products_id;
	}
	public void setProducts_id(String products_id) {
		this.products_id = products_id;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Booking [bill_no=" + bill_no + ", user_id=" + user_id + ", products_id=" + products_id + ", total="
				+ total + "]";
	}
}
