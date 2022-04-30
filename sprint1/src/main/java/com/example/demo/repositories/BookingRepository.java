package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Booking;


@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
	@Query("Select b FROM Booking b")
	Booking getBookings();
	@Query("Select b FROM Booking b WHERE bill_no=?1")
	Booking getBookingOnId(int bill_no);
	

}
