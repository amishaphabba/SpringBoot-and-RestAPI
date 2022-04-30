package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Inventory;
import com.example.demo.entities.Review;
import com.example.demo.services.InventoryService;
import com.example.demo.services.ReviewService;

@RestController
public class ReviewController {
	@Autowired
	ReviewService rs;
	
    @GetMapping("/review")
	public List<Review> getReviews(){
		return rs.getReviews();
	}
	
	@GetMapping("/review/{review_id}")
	public String getReviewOnId(@PathVariable int review_id) {
		return rs.getReviewOnId(review_id);	
	}
	
	@PostMapping("/review")
	public String addReview(@RequestBody Review review) {
		return rs.addReview(review);		
	}
	
	@PutMapping("/review/{review_id}")
	public String updateReview(@RequestBody Review review,@PathVariable int review_id) {
		return rs.updateReview(review,review_id);
	}
	
	@DeleteMapping("/review/{review_id}")
	public String deleteReview(@PathVariable int review_id ){
		return rs.deleteReview(review_id);
	}

}
