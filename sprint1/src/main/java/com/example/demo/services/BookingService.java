package com.example.demo.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Booking;
import com.example.demo.entities.Inventory;
import com.example.demo.entities.Offers;
import com.example.demo.entities.Tracking;
import com.example.demo.entities.Users;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.InventoryRepository;
import com.example.demo.repositories.OffersRepository;
import com.example.demo.repositories.TrackingRepository;
import com.example.demo.repositories.UsersRepository;

@Service
public class BookingService {
	@Autowired
	BookingRepository bookingrepo;
	@Autowired
	InventoryRepository inventoryrepo;
	@Autowired
	OffersRepository offersrepo;
	@Autowired
	TrackingRepository trackingrepo;
	@Autowired
	UsersRepository usersrepo;

	public String getBookings() {
		// TODO Auto-generated method stub
		List bookinglist = bookingrepo.findAll();
		if(bookinglist.size()!=0) {
			return bookinglist.toString();
		}
		return "empty list";
	}

	public String getBookingOnId(int bill_no) {
		// TODO Auto-generated method stub
		if(bookingrepo.existsById(bill_no)){
			return bookingrepo.getById(bill_no).toString();
		}
		return "no booking found with bill_no "+bill_no;	
	}

	public String addBooking(Booking booking) {
		
		if(usersrepo.getUserOnId(booking.getUser_id())!=null) {
			Users user = usersrepo.getById(booking.getUser_id());
			user.setOrders(booking.getProducts_id());
		}
		else {
			return "booking cancelled as wrong user_id given";
		}
		
		
//		int productlist[]=new int[100];
//		int count=0;
//		for(String i: booking.getProducts_id().split(",")) {
//			productlist[count]=Integer.valueOf(i);
//			count+=1;
//		}
		//doesnt work bcz productList[2,1,3,0,0,0,0,0....] so it gives error- no product available with id 0
		String[] productslist = booking.getProducts_id().split(",");
		float total=0;
		for(String i : productslist){
			int productId = Integer.valueOf(i);
			if(inventoryrepo.existsById(productId)) {
				Inventory inventory = inventoryrepo.getById(productId);
				inventory.setStock(inventory.getStock()-1);
				
				if(offersrepo.getOfferOnProductId(productId)!=null) {
					Offers offer = offersrepo.getOfferOnProductId(productId);
					LocalDate todaysDate = LocalDate.now();
					if(todaysDate.compareTo(offer.getStart_date())>=0 && todaysDate.compareTo(offer.getEnd_date())<=0) {
						total+=(float) (inventory.getPrice()-(inventory.getPrice()*(offer.getDiscount()/100.0)));	
					}
				}
				else {
					total+=inventory.getPrice();
				}
			}
			else {
				return "no product found with id "+productId;
			}
		}
		booking.setTotal(total);
        bookingrepo.save(booking);
		Tracking tracking = new Tracking();
		tracking.setBill_no(booking.getBill_no());
		tracking.setStatus("NOT-DISPATCHED");
		trackingrepo.save(tracking);
		return bookingrepo.save(booking).toString();
	}

	public String updateBooking(Booking booking, int bill_no) {
		// TODO Auto-generated method stub
		if(bookingrepo.existsById(bill_no)) {
			return "booking updated \n"+bookingrepo.save(booking).toString();
		}
		return "no booking found with id "+bill_no;																
	}

	public String deleteBooking(int bill_no) {
		// TODO Auto-generated method stub
		if(bookingrepo.existsById(bill_no)) {
			 Booking bookingdel = bookingrepo.getById(bill_no);
			 bookingrepo.delete(bookingdel);
			 return "booking deleted \n"+ bookingdel.toString();
		}
		return "no booking found with bill_no "+bill_no;
	}


}
