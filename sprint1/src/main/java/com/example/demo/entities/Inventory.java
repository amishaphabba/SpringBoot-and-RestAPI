package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int product_id;
	String pname;
	float price;
	int stock;
	public Inventory(int product_id, String pname, float price, int stock) {
		super();
		this.product_id = product_id;
		this.pname = pname;
		this.price = price;
		this.stock = stock;
	}
	
	Inventory(){}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Inventory [product_id=" + product_id + ", pname=" + pname + ", price=" + price + ", stock=" + stock
				+ "]";
	}
	
	

}
