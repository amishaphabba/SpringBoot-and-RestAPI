package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Offers;

@Repository
public interface OffersRepository extends JpaRepository<Offers, Integer>{
	@Query("SELECT s FROM Offers s WHERE s.product_id=?1")
	Offers getOfferOnProductId(int product_id);

}
