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

import com.example.demo.entities.Offers;
import com.example.demo.services.OffersService;

@RestController
public class OffersController {
	@Autowired
	OffersService os;

	@GetMapping("/offers")
	public String getOffers(){
		return os.getOffers();
	}
	
	@GetMapping("/offers/{product_id}")
	public String getOfferOnProductId(@PathVariable int product_id) {
		return os.getOfferOnProductId(product_id);
		
	}
	
	@PostMapping("/offers")
	public String addOffer(@RequestBody Offers offer) {
		return os.addOffer(offer);		
	}
	
	@PutMapping("/offers/{offer_id}")
	public String updateOffer(@RequestBody Offers offer,@PathVariable int offer_id) {
		return os.updateOffer(offer_id,offer);
		
	}
	
	@DeleteMapping("/offers/{offer_id}")
	public String deleteOffer(@PathVariable int offer_id ){
		return os.deleteOffer(offer_id);
	}
	
}
