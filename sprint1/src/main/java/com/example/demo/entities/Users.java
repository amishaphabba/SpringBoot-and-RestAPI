package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int user_id;
	String name;
	String email;
	String address;
	String orders;
	public Users(int user_id, String name, String email, String address, String orders) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.orders = orders;
	}
	Users(){}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrders() {
		return orders;
	}
	public void setOrders(String orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", orders=" + orders + "]";
	}	

}
