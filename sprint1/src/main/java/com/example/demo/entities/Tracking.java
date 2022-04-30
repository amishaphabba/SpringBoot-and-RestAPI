package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tracking {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int tracking_id;
	int bill_no;
	String status;
	public Tracking(int tracking_id, int bill_no, String status) {
		super();
		this.tracking_id = tracking_id;
		this.bill_no = bill_no;
		this.status = status;
	}
	public Tracking(){}
	public int getTracking_id() {
		return tracking_id;
	}
	public void setTracking_id(int tracking_id) {
		this.tracking_id = tracking_id;
	}
	public int getBill_no() {
		return bill_no;
	}
	public void setBill_no(int bill_no) {
		this.bill_no = bill_no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Tracking [tracking_id=" + tracking_id + ", bill_no=" + bill_no + ", status=" + status + "]";
	}
	
	

}
