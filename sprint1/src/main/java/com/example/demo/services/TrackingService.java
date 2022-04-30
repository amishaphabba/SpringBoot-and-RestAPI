package com.example.demo.services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Booking;
import com.example.demo.entities.Review;
import com.example.demo.entities.Tracking;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.ReviewRepository;
import com.example.demo.repositories.TrackingRepository;

@Service
public class TrackingService{
	
	@Autowired
	TrackingRepository trackingrepo;
	@Autowired
	ReviewRepository reviewrepo;
	@Autowired
	BookingRepository bookingrepo;
	

	public String getTrackings() {
		// TODO Auto-generated method stub
		List trackinglist = trackingrepo.findAll();
		if(trackinglist.size()!=0) {
			return trackinglist.toString();
		}
		return "empty list";
	}

	public String getTrackingOnId(int tracking_id) {
		// TODO Auto-generated method stub
		if(trackingrepo.existsById(tracking_id)){
			return trackingrepo.getById(tracking_id).toString();
		}
		return "no tracking found with id "+tracking_id;	
	}

	public String addTracking(Tracking tracking) {
		// TODO Auto-generated method stub
		return "tracking added \n"+trackingrepo.save(tracking).toString();
	}

	public String updateTracking(Tracking tracking, int tracking_id) {
		// TODO Auto-generated method stub
		if(trackingrepo.existsById(tracking_id)) {
			Booking booking = bookingrepo.getBookingOnId(tracking.getBill_no());
			String[] productsList = booking.getProducts_id().split(",");
			List<String> uniqueProductsList = new ArrayList<String>();
			for(int i=0;i<productsList.length;i++) {
				if(!(uniqueProductsList.contains(productsList[i]))) {
					uniqueProductsList.add(productsList[i]);
				}
			}
			
			for( String i:uniqueProductsList) {
				int productId = Integer.valueOf(i);
				if(tracking.getStatus().equals("DELIVERED")) {
					Review review = new Review();
					review.setReview_text(" add review here ");
					review.setStars(0);
					review.setProduct_id(productId);
					review.setUser_id(booking.getUser_id());
					reviewrepo.save(review);
				}
			}
			return "tracking updated \n"+trackingrepo.save(tracking).toString();
		}
		return "no tracking found with id "+tracking_id;	
		
	}

	public String deleteTracking(int tracking_id) {
		// TODO Auto-generated method stub
		if(trackingrepo.existsById(tracking_id)) {
			 Tracking trackingdel = trackingrepo.getById(tracking_id);
			 trackingrepo.delete(trackingdel);
			 return "tracking deleted \n"+ trackingdel.toString();
		}
		return "no tracking found with id "+tracking_id;
	}

}
