package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int review_id;
	int product_id;
	int user_id;
	String review_text;
	int stars;
	public Review(int review_id, int product_id, int user_id, String review_text, int stars) {
		super();
		this.review_id = review_id;
		this.product_id=product_id;
		this.user_id = user_id;
		this.review_text = review_text;
		this.stars = stars;
		
	}
	public Review(){}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public String getReview_text() {
		return review_text;
	}
	public void setReview_text(String review_text) {
		this.review_text = review_text;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Review [review_id=" + review_id + ", product_id=" + product_id + ", review_text=" + review_text
				+ ", stars=" + stars + "]";
	}
	
	
}
