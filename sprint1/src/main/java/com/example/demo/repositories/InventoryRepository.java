package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer>  {
	@Query("SELECT i FROM Inventory i WHERE product_id=?1")
	Inventory getProductOnId(int product_id);

}
