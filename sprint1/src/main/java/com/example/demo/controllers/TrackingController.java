package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Review;
import com.example.demo.entities.Tracking;
import com.example.demo.services.ReviewService;
import com.example.demo.services.TrackingService;

@RestController
public class TrackingController {
	@Autowired
	TrackingService ts;
	
    @GetMapping("/tracking")
	public String getTrackings(){
		return ts.getTrackings();
	}
	
	@GetMapping("/tracking/{tracking_id}")
	public String getTrackingOnId(@PathVariable int tracking_id) {
		return ts.getTrackingOnId(tracking_id);	
	}
	
	@PostMapping("/tracking")
	public String addTracking(@RequestBody Tracking tracking) {
		return ts.addTracking(tracking);		
	}
	@PutMapping("/tracking/{tracking_id}")
	public String updateTracking(@RequestBody Tracking tracking,@PathVariable int tracking_id) {
		return ts.updateTracking(tracking,tracking_id);
		
	}
	
	@DeleteMapping("/tracking/{tracking_id}")
	public String deleteTracking(@PathVariable int tracking_id ){
		return ts.deleteTracking(tracking_id);
	}
}
