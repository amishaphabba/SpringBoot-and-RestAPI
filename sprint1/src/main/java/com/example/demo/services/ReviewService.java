package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Inventory;
import com.example.demo.entities.Review;
import com.example.demo.repositories.InventoryRepository;
import com.example.demo.repositories.ReviewRepository;
@Service
public class ReviewService {
	
	@Autowired
	ReviewRepository reviewrepo;

	public List<Review> getReviews() {
		// TODO Auto-generated method stub
		List reviewlist = reviewrepo.findAll();
		if(reviewlist.size()!=0) {
			return reviewlist;
		}
		return null;
	}

	public String getReviewOnId(int review_id) {
		// TODO Auto-generated method stub
		if(reviewrepo.existsById(review_id)){
			return reviewrepo.getById(review_id).toString();
		}
		return "no review found with id "+review_id;	
	}

	public String addReview(Review review) {
		// TODO Auto-generated method stub
		return "review added \n"+reviewrepo.save(review).toString();
	}

	public String updateReview(Review review, int review_id) {
		// TODO Auto-generated method stub
		if(reviewrepo.existsById(review_id)) {
			return "review updated \n"+reviewrepo.save(review).toString();
		}
		return "no review found with id "+review_id;																
	}

	public String deleteReview(int review_id) {
		// TODO Auto-generated method stub
		if(reviewrepo.existsById(review_id)) {
			 Review reviewdel = reviewrepo.getById(review_id);
			 reviewrepo.delete(reviewdel);
			 return "review deleted \n"+ reviewdel.toString();
		}
		return "no review found with id "+review_id;
	}

}
