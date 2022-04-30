package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Tracking;

@Repository
public interface TrackingRepository extends JpaRepository<Tracking,Integer> {
	

}
