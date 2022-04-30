package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Offers;
import com.example.demo.repositories.InventoryRepository;
import com.example.demo.repositories.OffersRepository;

@Service
public class OffersService{
    @Autowired
    OffersRepository offersrepo;
    @Autowired
    InventoryRepository inventoryrepo;
	
	public String getOffers() {
		List<Offers> list1 = offersrepo.findAll();
		if(list1.size()!=0) {
			return list1.toString();
		}
		else {
			return "empty list";
		}
	}

	public String getOfferOnProductId(int product_id) {
		// TODO Auto-generated method stub
		if(offersrepo.existsById(product_id)) {
			 Offers offer = offersrepo.getById(product_id);
			 return offer.toString();
		}
		return "no offer found with product_id \n"+product_id;
		
		 
	}

	public String addOffer(Offers offer) {
		if(inventoryrepo.getProductOnId(offer.getProduct_id())!=null) {
			offersrepo.save(offer);
			return "Offer added \n"+offer.toString();
		}
		return "no product found of product_id "+offer.getProduct_id();   
	}

	public String updateOffer(int offer_id, Offers offer) {
//		if(offersrepo.existsById(offer_id)) {
//		  offers.rep
//		}
		Optional<Integer> op =Optional.of(offer_id); 
		if(op.isPresent()) {
			offersrepo.save(offer);
			return "offer updated \n"+ offer.toString();
		}
			return "no offer found with id "+offer_id;
	}

	public String deleteOffer(int offer_id) {
		if(offersrepo.existsById(offer_id)) {
			Offers doffer = offersrepo.getById(Integer.valueOf(offer_id));
			offersrepo.deleteById(Integer.valueOf(offer_id));
			return "offer deleted \n"+doffer.toString();
		}
		else {
			return "no offer found with id "+offer_id;
		}
		
	}
}
