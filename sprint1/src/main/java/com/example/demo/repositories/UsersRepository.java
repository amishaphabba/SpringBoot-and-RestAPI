package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer>{
	@Query("SELECT u from Users u WHERE user_id=?1")
	Users getUserOnId(int user_id);

}
