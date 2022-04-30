package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Booking;
import com.example.demo.services.BookingService;
//
@RestController
public class BookingController {
	@Autowired
	BookingService bs;
	
    @GetMapping("/booking")
	public String getBookings(){
		return bs.getBookings();
	}
	
	@GetMapping("/booking/{bill_no}")
	public String getBookingOnId(@PathVariable int bill_no) {
		return bs.getBookingOnId(bill_no);	
	}
	
	@PostMapping("/booking")
	public String addBooking(@RequestBody Booking booking) {
		return bs.addBooking(booking);		
	}
	@PutMapping("/booking/{bill_no}")
	public String updateBooking(@RequestBody Booking booking,@PathVariable int bill_no) {
		return bs.updateBooking(booking,bill_no);
		
	}
	
	@DeleteMapping("/booking/{bill_no}")
	public String deleteBooking(@PathVariable int bill_no ){
		return bs.deleteBooking(bill_no);
	}

}
